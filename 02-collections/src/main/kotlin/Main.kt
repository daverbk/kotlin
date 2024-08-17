package org.studies

fun main() {
    val name = "Kotlin"
    println("Hello, $name!")

    for (i in 1..5) {
        println("i = $i")
    }

    val readOnlyShapes = listOf("triangle", "square", "circle")
    println("This list has ${readOnlyShapes.count()} items")
}