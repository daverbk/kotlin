package conditional

import kotlin.random.Random

fun main() {
    val firstResult = Random.nextInt(6)
    val secondResult = Random.nextInt(6)

    if (firstResult == secondResult)
        println("You win :)")
    else
        println("You lose :(")

    println("Dice #1: $firstResult\nDice #2: $secondResult")
}