package controlstructures

fun isValidIdentifier(s: String): Boolean {
    fun isValidCharacter(c: Char) = c == '_' || c.isLetterOrDigit()

    if (s.isEmpty() || s[0].isDigit()) return false
    for (c in s) {
        if (!isValidCharacter(c)) return false
    }

    return true
}

fun main(args: Array<String>) {
    println(isValidIdentifier("name"))   // true
    println(isValidIdentifier("_name"))  // true
    println(isValidIdentifier("_12"))    // true
    println(isValidIdentifier("%12"))    // false
    println(isValidIdentifier(""))       // false
    println(isValidIdentifier("012"))    // false
    println(isValidIdentifier("no$"))    // false
}
