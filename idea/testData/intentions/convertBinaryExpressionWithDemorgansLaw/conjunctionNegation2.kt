// INTENTION_TEXT: Replace '&&' with '||'

fun foo(a: Boolean, b: Boolean, c: Boolean) : Boolean {
    return !(a && <caret>(b && c))
}