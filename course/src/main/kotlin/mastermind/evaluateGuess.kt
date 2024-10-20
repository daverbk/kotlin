package mastermind

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
    val secretCount = mutableMapOf(
        'A' to 0,
        'B' to 0,
        'C' to 0,
        'D' to 0,
        'E' to 0,
        'F' to 0
    )

    val guessCount = mutableMapOf(
        'A' to 0,
        'B' to 0,
        'C' to 0,
        'D' to 0,
        'E' to 0,
        'F' to 0
    )

    var right = 0
    var wrong = 0

    for ((index, char) in guess.withIndex()) {
        secretCount[secret[index]]?.apply {
            secretCount[secret[index]] = this + 1
        }
        guessCount[char]?.apply {
            guessCount[char] = this + 1
        }
    }

    for ((index, char) in guess.withIndex()) {
        if (secret[index] == char) {
            right++
            secretCount[char] = secretCount[char]!! - 1
            guessCount[char] = guessCount[char]!! - 1
        } else if (secretCount[char]!! == guessCount[char]!!) {
            wrong++
            secretCount[char] = secretCount[char]!! - 1
            guessCount[char] = guessCount[char]!! - 1
        } else if (secretCount[char]!! < guessCount[char]!!) {
            guessCount[char] = guessCount[char]!! - 1
        } else if (secretCount[char]!! > guessCount[char]!!) {
            secretCount[char] = secretCount[char]!! - 1
        }
    }

    return Evaluation(right, wrong + guessCount.values.sum())
}
