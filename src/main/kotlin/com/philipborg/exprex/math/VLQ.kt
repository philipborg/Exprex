package com.philipborg.exprex.math

import java.math.BigInteger
import java.math.RoundingMode

fun BigInteger.toVLQ(signed: Boolean = true): ByteArray {
    require(this.signum() >= 0 || signed)

    val absolute = this.abs()

    val bitLength = absolute.bitLength()
    val totalLength = Math.max(bitLength + if (signed) 1 else 0, 1)
    val bytes = totalLength.div(7, RoundingMode.UP)
    val maxByte = bytes - 1

    val response = ByteArray(bytes)

    for (bytePos in 0..maxByte) {
        var byteValue = 0
        val bitPos = bytePos * 7
        for (bit in 0..Math.min(6, bitLength - bitPos)) {
            if (absolute.testBit(bitPos + bit)) {
                byteValue = byteValue or (1 shl bit)
            }
        }
        response[maxByte - bytePos] = (byteValue or 0x80).toByte()
    }

    if (signum() == -1) {
        response[0] = (response[0].toInt() or 0x40).toByte()
    }

    response[maxByte] = (response[maxByte].toInt() and 0x7F).toByte()
    return response
}

fun Short.toVLQ(signed: Boolean = true): ByteArray = this.toBigInteger().toVLQ(signed)
fun Int.toVLQ(signed: Boolean = true): ByteArray = this.toBigInteger().toVLQ(signed)
fun Long.toVLQ(signed: Boolean = true): ByteArray = this.toBigInteger().toVLQ(signed)