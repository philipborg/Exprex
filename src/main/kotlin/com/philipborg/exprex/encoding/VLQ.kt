package com.philipborg.exprex.encoding

import com.philipborg.exprex.math.RoundingMode
import com.philipborg.exprex.math.div
import com.philipborg.exprex.math.toBigInteger
import com.philipborg.exprex.util.sliceWhereIncluding
import com.philipborg.exprex.util.takeWhileIncludingLast
import java.math.BigInteger

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
        for (bit in 0 until Math.min(7, bitLength - bitPos)) {
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
fun Array<BigInteger>.toVLQ(signed: Boolean = true): ByteArray = this.map { it.toVLQ(signed) }.flatMap { it.asIterable() }.toByteArray()
fun Sequence<BigInteger>.toVLQ(signed: Boolean = true): Sequence<Byte> = this.map { it.toVLQ(signed) }.flatMap { it.asSequence() }
fun Collection<BigInteger>.toVLQ(signed: Boolean = true): ByteArray = this.map { it.toVLQ(signed) }.flatMap { it.asIterable() }.toByteArray()

fun ByteArray.singleVLQ(signed: Boolean = true): BigInteger {
    require(this.dropLast(1).all { it.toInt() and 128 > 0 })
    require(this.last().toInt() shr 7 == 0)

    val dataBits = (7 * this.size) - if (signed) 1 else 0
    val responseLength = (dataBits + 1).div(8, RoundingMode.CEILING)
    val response = ByteArray(responseLength)
    val sizeDelta = responseLength * 8 - dataBits

    val range = when (signed) {
        true -> 1 until dataBits + 1
        false -> 0 until dataBits
    }

    for (bit in range) {
        if (this[bit / 7].toInt() and (0x40 ushr (bit % 7)) != 0) {
            val offset = bit + sizeDelta - if (signed) 1 else 0
            val targetPos = offset / 8
            val shifter = 0x80 ushr (offset % 8)
            response[targetPos] = (response[targetPos].toInt() or shifter).toByte()
        }
    }

    val signum = when (signed) {
        false -> 1
        true -> when (this[0].toInt() and 0x40) {
            0 -> 1
            else -> -1
        }
    }
    return BigInteger(signum, response)
}

fun Collection<Byte>.singleVLQ(signed: Boolean = true): BigInteger = this.toByteArray().singleVLQ(signed)

fun ByteArray.firstVLQ(signed: Boolean = true): BigInteger = this.asList().firstVLQ(signed)
fun Collection<Byte>.firstVLQ(signed: Boolean = true): BigInteger = this.takeWhileIncludingLast { it.toInt() and 128 > 0 }.singleVLQ(signed)

fun ByteArray.toVLQ(signed: Boolean = true): Sequence<BigInteger> = this.asList().toVLQ(signed)
fun Collection<Byte>.toVLQ(signed: Boolean = true): Sequence<BigInteger> = this.sliceWhereIncluding { it.toInt() shr 7 == 0 }.asSequence().map { it.singleVLQ(signed) }