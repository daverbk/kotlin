package builders

enum class Answer { a, b, c }

val answers = mapOf<Int, Answer?>(
    1 to Answer.c, 2 to Answer.b, 3 to Answer.b, 4 to Answer.c
)
