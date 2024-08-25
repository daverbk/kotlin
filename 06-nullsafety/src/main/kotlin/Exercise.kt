data class Employee3(val name: String, var salary: Int)

fun employeeById(id: Int) = when (id) {
    1 -> Employee3("Mary", 20)
    2 -> null
    3 -> Employee3("John", 21)
    4 -> Employee3("Ann", 23)
    else -> null
}

fun salaryById(id: Int) = employeeById(id)?.salary ?: 0

fun main() {
    println((1..5).sumOf { id -> salaryById(id) })
}