package com.philipborg.exprex.math

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