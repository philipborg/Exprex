package com.philipborg.exprex.math

import java.math.BigInteger

fun BigInteger.power(exponent: BigInteger, roundingMode: RoundingMode = RoundingMode.UNNECESSARY): BigInteger = when {
    this == BigInteger.ZERO -> when (exponent) {
        BigInteger.ZERO -> throw ArithmeticException("0 raised to the 0-th power is undefined")
        else -> BigInteger.ZERO
    }
    exponent >= BigInteger.ZERO -> when {
        exponent <= Int.MAX_VALUE.toBigInteger() -> this.pow(exponent.intValueExact())
        else -> throw NotImplementedError("Exponents larger than ${Int.MAX_VALUE} not supported.")
    }
    else -> BigInteger.ONE.div(this.power(exponent.abs()), roundingMode)
}

fun BigInteger.power(exponent: Byte, roundingMode: RoundingMode = RoundingMode.UNNECESSARY): BigInteger = this.power(exponent.toBigInteger(), roundingMode)

@ExperimentalUnsignedTypes
fun BigInteger.power(exponent: UByte, roundingMode: RoundingMode = RoundingMode.UNNECESSARY): BigInteger = this.power(exponent.toBigInteger(), roundingMode)

fun BigInteger.power(exponent: Short, roundingMode: RoundingMode = RoundingMode.UNNECESSARY): BigInteger = this.power(exponent.toBigInteger(), roundingMode)

@ExperimentalUnsignedTypes
fun BigInteger.power(exponent: UShort, roundingMode: RoundingMode = RoundingMode.UNNECESSARY): BigInteger = this.power(exponent.toBigInteger(), roundingMode)

fun BigInteger.power(exponent: Int, roundingMode: RoundingMode = RoundingMode.UNNECESSARY): BigInteger = this.power(exponent.toBigInteger(), roundingMode)

@ExperimentalUnsignedTypes
fun BigInteger.power(exponent: UInt, roundingMode: RoundingMode = RoundingMode.UNNECESSARY): BigInteger = this.power(exponent.toBigInteger(), roundingMode)

fun BigInteger.power(exponent: Long, roundingMode: RoundingMode = RoundingMode.UNNECESSARY): BigInteger = this.power(exponent.toBigInteger(), roundingMode)

@ExperimentalUnsignedTypes
fun BigInteger.power(exponent: ULong, roundingMode: RoundingMode = RoundingMode.UNNECESSARY): BigInteger = this.power(exponent.toBigInteger(), roundingMode)