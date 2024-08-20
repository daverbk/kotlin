package functions

import kotlin.math.pow

fun main() {
    println(circleArea(2.0))
}

fun circleArea(radius: Double) {
    radius.pow(2.0) * Math.PI
}