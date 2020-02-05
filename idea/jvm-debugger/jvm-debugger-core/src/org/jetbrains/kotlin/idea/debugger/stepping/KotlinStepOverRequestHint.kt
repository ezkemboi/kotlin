/*
 * Copyright 2010-2016 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.kotlin.idea.debugger.stepping

import com.intellij.debugger.engine.DebugProcess.JAVA_STRATUM
import com.intellij.debugger.engine.RequestHint
import com.intellij.debugger.engine.SuspendContextImpl
import com.intellij.debugger.engine.evaluation.EvaluateException
import com.intellij.debugger.jdi.ThreadReferenceProxyImpl
import com.intellij.openapi.diagnostic.Logger
import com.sun.jdi.Location
import com.sun.jdi.VMDisconnectedException
import com.sun.jdi.request.StepRequest
import org.jetbrains.kotlin.idea.debugger.safeLineNumber
import org.jetbrains.kotlin.idea.debugger.safeLocation
import org.jetbrains.kotlin.idea.debugger.safeMethod
import org.jetbrains.kotlin.load.java.JvmAbi

// Originally copied from RequestHint
class KotlinStepOverRequestHint(
    stepThread: ThreadReferenceProxyImpl,
    suspendContext: SuspendContextImpl,
    private val filter: KotlinMethodFilter
) : RequestHint(stepThread, suspendContext, StepRequest.STEP_LINE, StepRequest.STEP_OVER, filter) {
    private companion object {
        private val LOG = Logger.getInstance(KotlinStepOverRequestHint::class.java)
    }

    override fun getNextStepDepth(context: SuspendContextImpl): Int {
        try {
            val frameProxy = context.frameProxy ?: return STOP
            if (isTheSameFrame(context)) {
                val location = frameProxy.safeLocation()

                if (location != null && location.safeLineNumber() == JvmAbi.COROUTINE_BEFORE_SUSPEND_SYNTHETIC_LINE_NUMBER) {
                    // Coroutine will sleep now so we can't continue stepping.
                    // Let's put a run-to-cursor breakpoint and resume the debugger.
                    return if (!installCoroutineResumedBreakpoint(context)) STOP else RESUME
                }

                val isAcceptable = location != null && filter.locationMatches(context, location)
                return if (isAcceptable) STOP else StepRequest.STEP_OVER
            } else if (isSteppedOut) {
                val lineNumber = frameProxy.safeLocation()?.safeLineNumber(JAVA_STRATUM) ?: -1
                return if (lineNumber >= 0) STOP else StepRequest.STEP_OVER
            }

            return StepRequest.STEP_OUT
        } catch (ignored: VMDisconnectedException) {
        } catch (e: EvaluateException) {
            LOG.error(e)
        }

        return STOP
    }

    private fun installCoroutineResumedBreakpoint(context: SuspendContextImpl): Boolean {
        val frameProxy = context.frameProxy ?: return false
        val location = frameProxy.safeLocation() ?: return false
        val method = location.safeMethod() ?: return false

        context.debugProcess.cancelRunToCursorBreakpoint()
        return CoroutineBreakpointFacility.installCoroutineResumedBreakpoint(context, location, method)
    }
}