package com.philipborg.exprex.math

fun Byte.div(divisor: Byte, roundingMode: RoundingMode): Byte = this.toBigInteger().div(divisor, roundingMode).byteValueExact()
fun Byte.div(divisor: Short, roundingMode: RoundingMode): Byte = this.toBigInteger().div(divisor, roundingMode).byteValueExact()
fun Byte.div(divisor: Int, roundingMode: RoundingMode): Byte = this.toBigInteger().div(divisor, roundingMode).byteValueExact()
fun Byte.div(divisor: Long, roundingMode: RoundingMode): Byte = this.toBigInteger().div(divisor, roundingMode).byteValueExact()

fun Short.div(divisor: Byte, roundingMode: RoundingMode): Short = this.toBigInteger().div(divisor, roundingMode).shortValueExact()
fun Short.div(divisor: Short, roundingMode: RoundingMode): Short = this.toBigInteger().div(divisor, roundingMode).shortValueExact()
fun Short.div(divisor: Int, roundingMode: RoundingMode): Short = this.toBigInteger().div(divisor, roundingMode).shortValueExact()
fun Short.div(divisor: Long, roundingMode: RoundingMode): Short = this.toBigInteger().div(divisor, roundingMode).shortValueExact()

fun Int.div(divisor: Byte, roundingMode: RoundingMode): Int = this.toBigInteger().div(divisor, roundingMode).intValueExact()
fun Int.div(divisor: Short, roundingMode: RoundingMode): Int = this.toBigInteger().div(divisor, roundingMode).intValueExact()
fun Int.div(divisor: Int, roundingMode: RoundingMode): Int = this.toBigInteger().div(divisor, roundingMode).intValueExact()
fun Int.div(divisor: Long, roundingMode: RoundingMode): Int = this.toBigInteger().div(divisor, roundingMode).intValueExact()

fun Long.div(divisor: Byte, roundingMode: RoundingMode): Long = this.toBigInteger().div(divisor, roundingMode).longValueExact()
fun Long.div(divisor: Short, roundingMode: RoundingMode): Long = this.toBigInteger().div(divisor, roundingMode).longValueExact()
fun Long.div(divisor: Int, roundingMode: RoundingMode): Long = this.toBigInteger().div(divisor, roundingMode).longValueExact()
fun Long.div(divisor: Long, roundingMode: RoundingMode): Long = this.toBigInteger().div(divisor, roundingMode).longValueExact()