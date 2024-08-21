package lambdas

fun main() {
    repeatN(5) { println("Hello") }
}

fun repeatN(n: Int, action: () -> Unit) {
    for (i in 1..n) {
        action()
    }
}