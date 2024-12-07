package rationals

import java.math.BigInteger
import java.math.BigInteger.ONE
import java.math.BigInteger.ZERO

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

class Rational(n: BigInteger, d: BigInteger) : Comparable<Rational> {
    val numerator: BigInteger
    val denominator: BigInteger

    init {
        require(d != ZERO) { "Denominator must not be zero" }
        val gcd = n.gcd(d)
        val sign = d.signum().toBigInteger()
        numerator = n / gcd * sign
        denominator = d / gcd * sign
    }

    operator fun plus(other: Rational): Rational =
        Rational(
            numerator * other.denominator + other.numerator * denominator,
            denominator * other.denominator
        )

    operator fun minus(other: Rational): Rational =
        Rational(
            numerator * other.denominator - other.numerator * denominator,
            denominator * other.denominator
        )

    operator fun times(other: Rational): Rational =
        Rational(
            numerator * other.numerator,
            denominator * other.denominator
        )

    operator fun div(other: Rational): Rational =
        Rational(
            numerator * other.denominator,
            denominator * other.numerator
        )

    operator fun unaryMinus(): Rational = Rational(-numerator, denominator)

    override operator fun compareTo(other: Rational): Int =
        (numerator * other.denominator - other.numerator * denominator).signum()

    override fun toString(): String {
        if (denominator == ONE) return numerator.toString()
        return "$numerator/$denominator"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Rational

        if (numerator != other.numerator) return false
        if (denominator != other.denominator) return false

        return true
    }

    override fun hashCode(): Int {
        var result = numerator.hashCode()
        result = 31 * result + denominator.hashCode()
        return result
    }
}

infix fun Int.divBy(denominator: Int): Rational = Rational(this.toBigInteger(), denominator.toBigInteger())

infix fun Long.divBy(denominator: Long): Rational = Rational(this.toBigInteger(), denominator.toBigInteger())

infix fun BigInteger.divBy(denominator: BigInteger): Rational = Rational(this, denominator)

fun String.toRational(): Rational {
    fun String.toBigIntegerOrFail() = toBigIntegerOrNull() ?: throw IllegalArgumentException(
        "Expecting rational number in the form of 'n/d' or 'n', was: '${this@toRational}'"
    )

    val divIndex = indexOf('/')
    if (divIndex == -1) return Rational(toBigIntegerOrFail(), ONE)

    val numerator = substring(0, divIndex).toBigIntegerOrFail()
    val denominator = substring(divIndex + 1, length).toBigIntegerOrFail()

    return Rational(numerator, denominator)
}
