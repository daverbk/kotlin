package conventions

class Invokable {
    private var numberOfInvocations: Int = 0

    operator fun invoke(): Invokable {
        numberOfInvocations++
        println(numberOfInvocations)
        return this
    }
}

fun invokeTwice(invokable: Invokable) = invokable()()
