package com.philipborg.exprex.math

import java.math.BigInteger

fun BigInteger.div(divisor: BigInteger, roundingMode: RoundingMode = RoundingMode.UNNECESSARY): BigInteger {
    val result = when {
        divisor > BigInteger.ZERO -> this.divideAndRemainder(divisor)
        else -> this.negate().divideAndRemainder(divisor.negate())
    }
    return resolve(result[0], result[1], divisor, roundingMode)
}

private tailrec fun resolve(quotient: BigInteger, remainder: BigInteger, divisor: BigInteger, roundingMode: RoundingMode): BigInteger {
    if (remainder == BigInteger.ZERO)
        return quotient

    return when (roundingMode) {
        RoundingMode.CEILING -> when {
            remainder > BigInteger.ZERO -> quotient + BigInteger.ONE
            else -> quotient
        }
        RoundingMode.FLOOR -> when {
            remainder < BigInteger.ZERO -> quotient - BigInteger.ONE
            else -> quotient
        }
        RoundingMode.UNNECESSARY ->
            throw ArithmeticException("Not perfect division with rounding mode" + roundingMode.name)
        RoundingMode.UP -> when {
            quotient > BigInteger.ZERO -> quotient + BigInteger.ONE
            quotient < BigInteger.ZERO -> quotient - BigInteger.ONE
            quotient == BigInteger.ZERO -> when {
                remainder > BigInteger.ZERO -> BigInteger.ONE
                else -> -BigInteger.ONE
            }
            else -> throw ArithmeticException()
        }

        RoundingMode.DOWN -> quotient
        RoundingMode.HALF_DOWN -> when {
            (remainder * 2).abs() > divisor.abs() -> resolve(quotient, remainder, divisor, RoundingMode.UP)
            else -> resolve(quotient, remainder, divisor, RoundingMode.DOWN)
        }
        RoundingMode.HALF_UP -> when {
            (remainder * 2).abs() < divisor.abs() -> resolve(quotient, remainder, divisor, RoundingMode.DOWN)
            else -> resolve(quotient, remainder, divisor, RoundingMode.UP)
        }
        RoundingMode.HALF_EVEN -> {
            val mode = if (quotient.lowestSetBit == 0 && quotient > BigInteger.ZERO)
                RoundingMode.HALF_UP
            else
                RoundingMode.HALF_DOWN

            return resolve(quotient, remainder, divisor, mode)
        }
        // TODO Implement all RoundingModes
        else -> throw NotImplementedError("Rounding mode " + roundingMode.name)
    }
}

fun BigInteger.div(divisor: Byte, roundingMode: RoundingMode = RoundingMode.UNNECESSARY): BigInteger = this.div(divisor.toBigInteger(), roundingMode)
fun BigInteger.div(divisor: Short, roundingMode: RoundingMode = RoundingMode.UNNECESSARY): BigInteger = this.div(divisor.toBigInteger(), roundingMode)
fun BigInteger.div(divisor: Int, roundingMode: RoundingMode = RoundingMode.UNNECESSARY): BigInteger = this.div(divisor.toBigInteger(), roundingMode)
fun BigInteger.div(divisor: Long, roundingMode: RoundingMode = RoundingMode.UNNECESSARY): BigInteger = this.div(divisor.toBigInteger(), roundingMode)
