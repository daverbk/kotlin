package mastermind

fun evaluateGuessFunctional(secret: String, guess: String): Evaluation {

    val rightPositions = secret.zip(guess).count { it.first == it.second }

    val commonLetters = "ABCDEF".sumBy { ch ->

        Math.min(secret.count { it == ch }, guess.count { it == ch })
    }
    return Evaluation(rightPositions, commonLetters - rightPositions)
}
