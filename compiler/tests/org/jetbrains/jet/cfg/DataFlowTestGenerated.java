/*
 * Copyright 2010-2014 JetBrains s.r.o.
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

package org.jetbrains.jet.cfg;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestSuite;

import java.io.File;
import java.util.regex.Pattern;
import org.jetbrains.jet.JetTestUtils;
import org.jetbrains.jet.test.InnerTestClasses;
import org.jetbrains.jet.test.TestMetadata;

import org.jetbrains.jet.cfg.AbstractDataFlowTest;

/** This class is generated by {@link org.jetbrains.jet.generators.tests.TestsPackage}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("compiler/testData/cfg-variables")
@InnerTestClasses({DataFlowTestGenerated.Basic.class, DataFlowTestGenerated.LexicalScopes.class})
public class DataFlowTestGenerated extends AbstractDataFlowTest {
    public void testAllFilesPresentInCfg_variables() throws Exception {
        JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), "org.jetbrains.jet.generators.tests.TestsPackage", new File("compiler/testData/cfg-variables"), Pattern.compile("^(.+)\\.kt$"), true);
    }
    
    @TestMetadata("compiler/testData/cfg-variables/basic")
    public static class Basic extends AbstractDataFlowTest {
        public void testAllFilesPresentInBasic() throws Exception {
            JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), "org.jetbrains.jet.generators.tests.TestsPackage", new File("compiler/testData/cfg-variables/basic"), Pattern.compile("^(.+)\\.kt$"), true);
        }
        
        @TestMetadata("IfWithUninitialized.kt")
        public void testIfWithUninitialized() throws Exception {
            doTest("compiler/testData/cfg-variables/basic/IfWithUninitialized.kt");
        }
        
        @TestMetadata("InitializedNotDeclared.kt")
        public void testInitializedNotDeclared() throws Exception {
            doTest("compiler/testData/cfg-variables/basic/InitializedNotDeclared.kt");
        }
        
        @TestMetadata("UsageInFunctionLiteral.kt")
        public void testUsageInFunctionLiteral() throws Exception {
            doTest("compiler/testData/cfg-variables/basic/UsageInFunctionLiteral.kt");
        }
        
        @TestMetadata("VariablesInitialization.kt")
        public void testVariablesInitialization() throws Exception {
            doTest("compiler/testData/cfg-variables/basic/VariablesInitialization.kt");
        }
        
        @TestMetadata("VariablesUsage.kt")
        public void testVariablesUsage() throws Exception {
            doTest("compiler/testData/cfg-variables/basic/VariablesUsage.kt");
        }
        
    }
    
    @TestMetadata("compiler/testData/cfg-variables/lexicalScopes")
    public static class LexicalScopes extends AbstractDataFlowTest {
        public void testAllFilesPresentInLexicalScopes() throws Exception {
            JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), "org.jetbrains.jet.generators.tests.TestsPackage", new File("compiler/testData/cfg-variables/lexicalScopes"), Pattern.compile("^(.+)\\.kt$"), true);
        }
        
        @TestMetadata("doWhileScope.kt")
        public void testDoWhileScope() throws Exception {
            doTest("compiler/testData/cfg-variables/lexicalScopes/doWhileScope.kt");
        }
        
        @TestMetadata("forScope.kt")
        public void testForScope() throws Exception {
            doTest("compiler/testData/cfg-variables/lexicalScopes/forScope.kt");
        }
        
        @TestMetadata("functionLiteralScope.kt")
        public void testFunctionLiteralScope() throws Exception {
            doTest("compiler/testData/cfg-variables/lexicalScopes/functionLiteralScope.kt");
        }
        
        @TestMetadata("ifScope.kt")
        public void testIfScope() throws Exception {
            doTest("compiler/testData/cfg-variables/lexicalScopes/ifScope.kt");
        }
        
        @TestMetadata("localClass.kt")
        public void testLocalClass() throws Exception {
            doTest("compiler/testData/cfg-variables/lexicalScopes/localClass.kt");
        }
        
        @TestMetadata("localFunctionScope.kt")
        public void testLocalFunctionScope() throws Exception {
            doTest("compiler/testData/cfg-variables/lexicalScopes/localFunctionScope.kt");
        }
        
        @TestMetadata("localFunctionScopeWithoutBody.kt")
        public void testLocalFunctionScopeWithoutBody() throws Exception {
            doTest("compiler/testData/cfg-variables/lexicalScopes/localFunctionScopeWithoutBody.kt");
        }
        
        @TestMetadata("localObject.kt")
        public void testLocalObject() throws Exception {
            doTest("compiler/testData/cfg-variables/lexicalScopes/localObject.kt");
        }
        
        @TestMetadata("objectLiteralScope.kt")
        public void testObjectLiteralScope() throws Exception {
            doTest("compiler/testData/cfg-variables/lexicalScopes/objectLiteralScope.kt");
        }
        
        @TestMetadata("propertyAccessorScope.kt")
        public void testPropertyAccessorScope() throws Exception {
            doTest("compiler/testData/cfg-variables/lexicalScopes/propertyAccessorScope.kt");
        }
        
        @TestMetadata("tryScope.kt")
        public void testTryScope() throws Exception {
            doTest("compiler/testData/cfg-variables/lexicalScopes/tryScope.kt");
        }
        
        @TestMetadata("whileScope.kt")
        public void testWhileScope() throws Exception {
            doTest("compiler/testData/cfg-variables/lexicalScopes/whileScope.kt");
        }
        
    }
    
    public static Test suite() {
        TestSuite suite = new TestSuite("DataFlowTestGenerated");
        suite.addTestSuite(DataFlowTestGenerated.class);
        suite.addTestSuite(Basic.class);
        suite.addTestSuite(LexicalScopes.class);
        return suite;
    }
}
