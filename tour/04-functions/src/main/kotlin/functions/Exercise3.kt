package functions

fun main() {
    println(intervalInSeconds(hours = 1, minutes = 20, seconds = 15))
    println(intervalInSeconds(hours = 1, minutes = 25))
    println(intervalInSeconds(hours = 2))
    println(intervalInSeconds(hours = 10))
    println(intervalInSeconds(hours = 1, minutes = 1))
}

fun intervalInSeconds(hours: Int = 0, minutes: Int = 0, seconds: Int = 0) =
    ((hours * 60) + minutes) * 60 + seconds
