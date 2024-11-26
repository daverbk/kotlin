package rationals

import java.math.BigInteger

fun main() {
    val half = 1 divBy 2
    val third = 1 divBy 3

    val sum: Rational = half + third
    println(5 divBy 6 == sum)

    val difference: Rational = half - third
    println(1 divBy 6 == difference)

    val product: Rational = half * third
    println(1 divBy 6 == product)

    val quotient: Rational = half / third
    println(3 divBy 2 == quotient)

    val negation: Rational = -half
    println(-1 divBy 2 == negation)

    println((2 divBy 1).toString() == "2")
    println((-2 divBy 4).toString() == "-1/2")
    println("117/1098".toRational().toString() == "13/122")

    val twoThirds = 2 divBy 3
    println(half < twoThirds)

    println(half in third..twoThirds)

    println(2000000000L divBy 4000000000L == 1 divBy 2)

    println(
        "912016490186296920119201192141970416029".toBigInteger() divBy
                "1824032980372593840238402384283940832058".toBigInteger() == 1 divBy 2
    )
}

infix fun Int.divBy(i: Int): Rational = Rational(this.toBigInteger(), i.toBigInteger())

infix fun Long.divBy(i: Long): Rational = Rational(this.toBigInteger(), i.toBigInteger())

infix fun BigInteger.divBy(i: BigInteger): Rational = Rational(this, i)

fun String.toRational(): Rational {
    val divIndex = this.indexOf('/')
    if (divIndex == -1) return Rational(this.toBigInteger(), BigInteger.ONE)

    val numerator = this.substring(0, divIndex).toBigInteger()
    val denominator = this.substring(divIndex + 1, this.length).toBigInteger()

    return Rational(numerator, denominator)
}

operator fun RationalRange.contains(rational: Rational): Boolean {

}

class RationalRange(override val endInclusive: Int, override val start: Int) : Iterable<Rational>, ClosedRange<Int> {
    override fun iterator(): Iterator<Rational> {

    }
}

data class Rational(val numerator: BigInteger, val denominator: BigInteger) {

    init {
        if (denominator == BigInteger.ZERO)
            throw IllegalArgumentException("The denominator cannot be less or equal to zero")
    }

    operator fun plus(another: Rational): Rational {

    }

    operator fun minus(another: Rational): Rational {

    }

    operator fun times(another: Rational): Rational {

    }

    operator fun div(another: Rational): Rational {

    }

    operator fun compareTo(another: Rational): Int {

    }

    operator fun rangeTo(to: Rational): RationalRange {

    }

    operator fun unaryMinus(): Rational {

    }
}
