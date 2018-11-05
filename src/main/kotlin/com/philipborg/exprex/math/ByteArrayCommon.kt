package com.philipborg.exprex.math

import java.math.BigInteger

fun Short.toBytes(endianness: Endian = Endian.BIG_ENDIAN): ByteArray {
    val input = this.toInt()
    return when (endianness) {
        Endian.BIG_ENDIAN -> byteArrayOf(
                (input shr 8 and 0xff).toByte(),
                (input and 0xff).toByte()
        )
        Endian.LITTLE_ENDIAN -> byteArrayOf(
                (input and 0xff).toByte(),
                (input shr 8 and 0xff).toByte()
        )
    }
}

@ExperimentalUnsignedTypes
fun UShort.toBytes(endianness: Endian = Endian.BIG_ENDIAN): ByteArray = this.toShort().toBytes(endianness)

fun Int.toBytes(endianness: Endian = Endian.BIG_ENDIAN): ByteArray = when (endianness) {
    Endian.BIG_ENDIAN -> byteArrayOf(
            (this shr 24 and 0xff).toByte(),
            (this shr 16 and 0xff).toByte(),
            (this shr 8 and 0xff).toByte(),
            (this and 0xff).toByte()
    )
    Endian.LITTLE_ENDIAN -> byteArrayOf(
            (this and 0xff).toByte(),
            (this shr 8 and 0xff).toByte(),
            (this shr 16 and 0xff).toByte(),
            (this shr 24 and 0xff).toByte()
    )
}

@ExperimentalUnsignedTypes
fun UInt.toBytes(endianness: Endian = Endian.BIG_ENDIAN): ByteArray = this.toInt().toBytes(endianness)

fun Long.toBytes(endianness: Endian = Endian.BIG_ENDIAN): ByteArray = when (endianness) {
    Endian.BIG_ENDIAN -> byteArrayOf(
            (this shr 56 and 0xff).toByte(),
            (this shr 48 and 0xff).toByte(),
            (this shr 40 and 0xff).toByte(),
            (this shr 32 and 0xff).toByte(),
            (this shr 24 and 0xff).toByte(),
            (this shr 16 and 0xff).toByte(),
            (this shr 8 and 0xff).toByte(),
            (this and 0xff).toByte()
    )
    Endian.LITTLE_ENDIAN -> byteArrayOf(
            (this and 0xff).toByte(),
            (this shr 8 and 0xff).toByte(),
            (this shr 16 and 0xff).toByte(),
            (this shr 24 and 0xff).toByte(),
            (this shr 32 and 0xff).toByte(),
            (this shr 40 and 0xff).toByte(),
            (this shr 48 and 0xff).toByte(),
            (this shr 56 and 0xff).toByte()
    )
}

@ExperimentalUnsignedTypes
fun ULong.toBytes(endianness: Endian = Endian.BIG_ENDIAN): ByteArray = this.toLong().toBytes(endianness)

fun BigInteger.toBytes(endianness: Endian = Endian.BIG_ENDIAN): ByteArray = when (endianness) {
    Endian.BIG_ENDIAN -> this.toByteArray()
    Endian.LITTLE_ENDIAN -> this.toByteArray().reversed().toByteArray()
}