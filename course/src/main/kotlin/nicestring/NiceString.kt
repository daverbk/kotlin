package nicestring

fun String.isNice(): Boolean {
    val noBadSubstring = !contains("ba") && !contains("be") && !contains("bu")
    // more kotlinish
    // setOf("ba", "be", "bu").none { this.contains(it) }

    val hasThreeVowels = count { it == 'a' || it == 'e' || it == 'i' || it == 'o' || it == 'u' } >= 3
    // more kotlinish
    // count { it in "aeiou" } >= 3

    var hasDouble = false
    if (length > 1) {
        var prevCh: Char? = null
        for (ch in this) {
            if (ch == prevCh) {
                hasDouble = true
            }
            prevCh = ch
        }
    }
    // more kotlinish
    // (0 until lastIndex).any { this[it] == this[it + 1]
    // zipWithNext().any { it[0] == it.second }
    // windowed(2).any { it[0] == it[1] }

    var conditions = 0
    if (noBadSubstring) conditions++
    if (hasThreeVowels) conditions++
    if (hasDouble) conditions++

    return conditions >= 2
    // more kotlinish
    // return listOf(noBadSubstring, hasThreeVowels, hasDouble).count { it } >= 2
}
