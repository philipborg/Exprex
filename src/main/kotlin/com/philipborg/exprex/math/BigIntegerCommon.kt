package com.philipborg.exprex.math

import java.math.BigInteger


operator fun BigInteger.times(factor: Byte): BigInteger = this * factor.toBigInteger()
operator fun BigInteger.times(factor: Short): BigInteger = this * factor.toBigInteger()
operator fun BigInteger.times(factor: Int): BigInteger = this * factor.toBigInteger()
operator fun BigInteger.times(factor: Long): BigInteger = this * factor.toBigInteger()

fun Byte.toBigInteger(): BigInteger = this.toLong().toBigInteger()

@ExperimentalUnsignedTypes
fun UByte.toBigInteger(): BigInteger = this.toLong().toBigInteger()

fun Short.toBigInteger(): BigInteger = this.toLong().toBigInteger()

@ExperimentalUnsignedTypes
fun UShort.toBigInteger(): BigInteger = this.toLong().toBigInteger()

@ExperimentalUnsignedTypes
fun UInt.toBigInteger(): BigInteger = this.toLong().toBigInteger()

@ExperimentalUnsignedTypes
//TODO Optimize to use byte arrays instead of strings
fun ULong.toBigInteger(): BigInteger = BigInteger(this.toString(Character.MAX_RADIX), Character.MAX_RADIX)