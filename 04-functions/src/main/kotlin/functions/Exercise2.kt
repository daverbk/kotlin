package functions

import kotlin.math.pow

fun main() {
    println(circleAreaSingleExpression(2.0))
}

fun circleAreaSingleExpression(radius: Double) = radius.pow(2.0) * Math.PI