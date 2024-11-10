package funtionalprogramming

fun List<Int>.allNonZero() = all { it != 0 }
fun List<Int>.allNonZero1() = none { it == 0 }
fun List<Int>.allNonZero2() = !any { it == 0 }

fun List<Int>.containsZero() = any { it == 0 }
fun List<Int>.containsZero1() = !all { it != 0 }
fun List<Int>.containsZero2() = !none { it == 0 }

fun main() {
    val list1 = listOf(1, 2, 3)
    println(list1.allNonZero()) // true
    println(list1.allNonZero1()) // true
    println(list1.allNonZero2()) // true

    println(list1.containsZero()) // false
    println(list1.containsZero1()) // false
    println(list1.containsZero2()) // false

    val list2 = listOf(0, 1, 2)
    println(list2.allNonZero()) // false
    println(list2.allNonZero1()) // false
    println(list2.allNonZero2()) // false

    println(list2.containsZero()) // true
    println(list2.containsZero1()) // true
    println(list2.containsZero2()) // true
}
