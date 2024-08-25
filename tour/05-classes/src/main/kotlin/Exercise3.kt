import kotlin.random.Random

data class Employee2(val name: String, var salary: Int)

class RandomEmployeeGenerator(var minSalary: Int, var maxSalary: Int) {
    private val potentialNames = listOf("Mary", "Alex", "Susan", "Paul", "Jack", "Elizabeth")

    fun generateEmployee(): Employee2 = Employee2(
        potentialNames.random(),
        Random.nextInt(
            from = minSalary, until = maxSalary
        )
    )
}

fun main() {
    val empGen = RandomEmployeeGenerator(10, 30)
    println(empGen.generateEmployee())
    println(empGen.generateEmployee())
    println(empGen.generateEmployee())
    empGen.minSalary = 50
    empGen.maxSalary = 100
    println(empGen.generateEmployee())
}