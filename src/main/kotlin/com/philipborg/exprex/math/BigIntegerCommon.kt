package com.philipborg.exprex.math

import java.math.BigInteger


operator fun BigInteger.times(factor: Byte): BigInteger = this * factor.toBigInteger()
operator fun BigInteger.times(factor: Short): BigInteger = this * factor.toBigInteger()
operator fun BigInteger.times(factor: Int): BigInteger = this * factor.toBigInteger()
operator fun BigInteger.times(factor: Long): BigInteger = this * factor.toBigInteger()

fun Byte.toBigInteger(): BigInteger = this.toLong().toBigInteger()
fun Short.toBigInteger(): BigInteger = this.toLong().toBigInteger()