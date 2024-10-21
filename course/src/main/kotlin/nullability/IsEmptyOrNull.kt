package nullability

fun main(args: Array<String>) {
    val s1: String? = null
    val s2: String? = ""
    s1.isEmptyOrNull()
    s2.isEmptyOrNull()

    val s3 = "   "
    s3.isEmptyOrNull() // <-- can be called without ?
}

fun String?.isEmptyOrNull() = this == null || isEmpty()
