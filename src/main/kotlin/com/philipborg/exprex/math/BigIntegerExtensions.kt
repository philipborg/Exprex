package com.philipborg.exprex.math

import java.math.BigInteger
import java.math.RoundingMode

fun BigInteger.div(divisor: BigInteger, roundingMode: RoundingMode = RoundingMode.UNNECESSARY): BigInteger {
    val result = when {
        divisor > BigInteger.ZERO -> this.divideAndRemainder(divisor)
        else -> (this * -BigInteger.ONE).divideAndRemainder(divisor * -BigInteger.ONE)
    }

    if (result[1] == BigInteger.ZERO)
        return result[0]

    return when (roundingMode) {
        RoundingMode.CEILING -> when {
            result[1] > BigInteger.ZERO -> result[0] + BigInteger.ONE
            else -> result[0]
        }
        RoundingMode.FLOOR -> when {
            result[1] < BigInteger.ZERO -> result[0] - BigInteger.ONE
            else -> result[0]
        }
        RoundingMode.UNNECESSARY ->
            throw ArithmeticException("Not perfect division with rounding mode" + roundingMode.name)
        RoundingMode.UP -> {
            when {
                result[0] > BigInteger.ZERO -> result[0] + BigInteger.ONE
                result[0] < BigInteger.ZERO -> result[0] - BigInteger.ONE
                result[0] == BigInteger.ZERO -> when {
                    result[1] > BigInteger.ZERO -> BigInteger.ONE
                    else -> -BigInteger.ONE
                }
                else -> throw ArithmeticException()
            }
        }
        RoundingMode.DOWN -> result[0]
        RoundingMode.HALF_UP -> TODO()
        RoundingMode.HALF_DOWN -> TODO()
        RoundingMode.HALF_EVEN -> TODO()
        else -> throw NotImplementedError("Rounding mode " + roundingMode.name)
    }
}

fun BigInteger.div(divisor: Byte, roundingMode: RoundingMode = RoundingMode.UNNECESSARY): BigInteger = this.div(divisor.toBigInteger(), roundingMode)
fun BigInteger.div(divisor: Short, roundingMode: RoundingMode = RoundingMode.UNNECESSARY): BigInteger = this.div(divisor.toBigInteger(), roundingMode)
fun BigInteger.div(divisor: Int, roundingMode: RoundingMode = RoundingMode.UNNECESSARY): BigInteger = this.div(divisor.toBigInteger(), roundingMode)
fun BigInteger.div(divisor: Long, roundingMode: RoundingMode = RoundingMode.UNNECESSARY): BigInteger = this.div(divisor.toBigInteger(), roundingMode)

fun Byte.toBigInteger(): BigInteger = this.toLong().toBigInteger()
fun Short.toBigInteger(): BigInteger = this.toLong().toBigInteger()