package introduction

fun main() {
    checkAge(10)
}

fun checkAge(age: Int?) {
    if (age == null || age !in 0..150) failWithWrongAge(age)
    println("Congrats! Next year you'll be ${age + 1}.")
}

fun failWithWrongAge(age: Int?): Nothing {
    throw IllegalArgumentException("Wrong age: $age")
}
