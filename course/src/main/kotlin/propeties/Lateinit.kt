package propeties

class A {
    private lateinit var prop: String

    fun setUp() {
        prop = "value"
    }

    fun display() {
        println(prop)
    }
}

fun main(args: Array<String>) {
    val a = A()
    a.setUp() // <-- without this an UninitializedPropertyAccessException is thrown
    a.display()
}
