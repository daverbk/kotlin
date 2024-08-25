package loop

fun main() {
    val fizz = "fizz"
    val buzz = "buzz"

    for (num in 1..100) {
        println(
            when {
                num % 15 == 0 -> fizz + buzz
                num % 3 == 0 -> fizz
                num % 5 == 0 -> buzz
                else -> num
            }
        )
    }
}