package nullability

fun main(args: Array<String>) {
    val s = ""
    println(s as? Int)    // null
    println(s as Int?)    // exception
}
