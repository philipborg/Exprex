package com.philipborg.exprex.test.math

import com.philipborg.exprex.math.Endian
import com.philipborg.exprex.math.toBytes
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ByteArrayConversions {
    //Short
    @Test
    fun maxShortBigEndian() {
        Assertions.assertArrayEquals(byteArrayOf(127, -1), Short.MAX_VALUE.toBytes(Endian.BIG_ENDIAN))
    }

    @Test
    fun minShortBigEndian() {
        Assertions.assertArrayEquals(byteArrayOf(-128, 0), Short.MIN_VALUE.toBytes(Endian.BIG_ENDIAN))
    }

    @Test
    fun maxShortLittleEndian() {
        Assertions.assertArrayEquals(byteArrayOf(-1, 127), Short.MAX_VALUE.toBytes(Endian.LITTLE_ENDIAN))
    }

    @Test
    fun minShortLittleEndian() {
        Assertions.assertArrayEquals(byteArrayOf(0, -128), Short.MIN_VALUE.toBytes(Endian.LITTLE_ENDIAN))
    }

    //UShort
    @ExperimentalUnsignedTypes
    @Test
    fun maxUShortBigEndian() {
        Assertions.assertArrayEquals(byteArrayOf(-1, -1), UShort.MAX_VALUE.toBytes(Endian.BIG_ENDIAN))
    }

    @ExperimentalUnsignedTypes
    @Test
    fun minUShortBigEndian() {
        Assertions.assertArrayEquals(byteArrayOf(0, 0), UShort.MIN_VALUE.toBytes(Endian.BIG_ENDIAN))
    }

    @ExperimentalUnsignedTypes
    @Test
    fun maxUShortLittleEndian() {
        Assertions.assertArrayEquals(byteArrayOf(-1, -1), UShort.MAX_VALUE.toBytes(Endian.LITTLE_ENDIAN))
    }

    @ExperimentalUnsignedTypes
    @Test
    fun minUShortLittleEndian() {
        Assertions.assertArrayEquals(byteArrayOf(0, 0), UShort.MIN_VALUE.toBytes(Endian.LITTLE_ENDIAN))
    }

    @ExperimentalUnsignedTypes
    @Test
    fun middleUShortBigEndian() {
        Assertions.assertArrayEquals(byteArrayOf(-118, 11), 35339.toUShort().toBytes(Endian.BIG_ENDIAN))
    }

    @ExperimentalUnsignedTypes
    @Test
    fun middleUShortLittleEndian() {
        Assertions.assertArrayEquals(byteArrayOf(11, -118), 35339.toUShort().toBytes(Endian.LITTLE_ENDIAN))
    }

    //Int
    @Test
    fun maxIntBigEndian() {
        Assertions.assertArrayEquals(byteArrayOf(127, -1, -1, -1), Int.MAX_VALUE.toBytes(Endian.BIG_ENDIAN))
    }

    @Test
    fun minIntBigEndian() {
        Assertions.assertArrayEquals(byteArrayOf(-128, 0, 0, 0), Int.MIN_VALUE.toBytes(Endian.BIG_ENDIAN))
    }

    @Test
    fun maxIntLittleEndian() {
        Assertions.assertArrayEquals(byteArrayOf(-1, -1, -1, 127), Int.MAX_VALUE.toBytes(Endian.LITTLE_ENDIAN))
    }

    @Test
    fun minIntLittleEndian() {
        Assertions.assertArrayEquals(byteArrayOf(0, 0, 0, -128), Int.MIN_VALUE.toBytes(Endian.LITTLE_ENDIAN))
    }

    //UInt
    @ExperimentalUnsignedTypes
    @Test
    fun maxUIntBigEndian() {
        Assertions.assertArrayEquals(byteArrayOf(-1, -1, -1, -1), UInt.MAX_VALUE.toBytes(Endian.BIG_ENDIAN))
    }

    @ExperimentalUnsignedTypes
    @Test
    fun minUIntBigEndian() {
        Assertions.assertArrayEquals(byteArrayOf(0, 0, 0, 0), UInt.MIN_VALUE.toBytes(Endian.BIG_ENDIAN))
    }

    @ExperimentalUnsignedTypes
    @Test
    fun maxUIntLittleEndian() {
        Assertions.assertArrayEquals(byteArrayOf(-1, -1, -1, -1), UInt.MAX_VALUE.toBytes(Endian.LITTLE_ENDIAN))
    }

    @ExperimentalUnsignedTypes
    @Test
    fun minUIntLittleEndian() {
        Assertions.assertArrayEquals(byteArrayOf(0, 0, 0, 0), UInt.MIN_VALUE.toBytes(Endian.LITTLE_ENDIAN))
    }

    @ExperimentalUnsignedTypes
    @Test
    fun middleUIntBigEndian() {
        Assertions.assertArrayEquals(byteArrayOf(-118, 11, 12, 13), 2315979789.toUInt().toBytes(Endian.BIG_ENDIAN))
    }

    @ExperimentalUnsignedTypes
    @Test
    fun middleUIntLittleEndian() {
        Assertions.assertArrayEquals(byteArrayOf(13, 12, 11, -118), 2315979789.toUInt().toBytes(Endian.LITTLE_ENDIAN))
    }

    //Long
    @Test
    fun maxLongBigEndian() {
        Assertions.assertArrayEquals(byteArrayOf(127, -1, -1, -1, -1, -1, -1, -1), Long.MAX_VALUE.toBytes(Endian.BIG_ENDIAN))
    }

    @Test
    fun minLongBigEndian() {
        Assertions.assertArrayEquals(byteArrayOf(-128, 0, 0, 0, 0, 0, 0, 0), Long.MIN_VALUE.toBytes(Endian.BIG_ENDIAN))
    }

    @Test
    fun maxLongLittleEndian() {
        Assertions.assertArrayEquals(byteArrayOf(-1, -1, -1, -1, -1, -1, -1, 127), Long.MAX_VALUE.toBytes(Endian.LITTLE_ENDIAN))
    }

    @Test
    fun minLongLittleEndian() {
        Assertions.assertArrayEquals(byteArrayOf(0, 0, 0, 0, 0, 0, 0, -128), Long.MIN_VALUE.toBytes(Endian.LITTLE_ENDIAN))
    }

    //ULong
    @ExperimentalUnsignedTypes
    @Test
    fun maxULongBigEndian() {
        Assertions.assertArrayEquals(byteArrayOf(-1, -1, -1, -1, -1, -1, -1, -1), ULong.MAX_VALUE.toBytes(Endian.BIG_ENDIAN))
    }

    @ExperimentalUnsignedTypes
    @Test
    fun minULongBigEndian() {
        Assertions.assertArrayEquals(byteArrayOf(0, 0, 0, 0, 0, 0, 0, 0), ULong.MIN_VALUE.toBytes(Endian.BIG_ENDIAN))
    }

    @ExperimentalUnsignedTypes
    @Test
    fun maxULongLittleEndian() {
        Assertions.assertArrayEquals(byteArrayOf(-1, -1, -1, -1, -1, -1, -1, -1), ULong.MAX_VALUE.toBytes(Endian.LITTLE_ENDIAN))
    }

    @ExperimentalUnsignedTypes
    @Test
    fun minULongLittleEndian() {
        Assertions.assertArrayEquals(byteArrayOf(0, 0, 0, 0, 0, 0, 0, 0), ULong.MIN_VALUE.toBytes(Endian.LITTLE_ENDIAN))
    }

    @ExperimentalUnsignedTypes
    @Test
    fun middleULongBigEndian() {
        Assertions.assertArrayEquals(byteArrayOf(-118, 11, 12, 13, 14, 15, 16, 17), "9947057452187848721".toULong().toBytes(Endian.BIG_ENDIAN))
    }

    @ExperimentalUnsignedTypes
    @Test
    fun middleULongLittleEndian() {
        Assertions.assertArrayEquals(byteArrayOf(17, 16, 15, 14, 13, 12, 11, -118), "9947057452187848721".toULong().toBytes(Endian.LITTLE_ENDIAN))
    }

    //BigInteger
    @Test
    fun positiveBigIntegerBigEndian() {
        Assertions.assertArrayEquals(byteArrayOf(127, -1, -1, -1), Int.MAX_VALUE.toBigInteger().toBytes(Endian.BIG_ENDIAN))
    }

    @Test
    fun negativeBigIntegerBigEndian() {
        Assertions.assertArrayEquals(byteArrayOf(-128, 0, 0, 0), Int.MIN_VALUE.toBigInteger().toBytes(Endian.BIG_ENDIAN))
    }

    @Test
    fun positiveBigIntegerLittleEndian() {
        Assertions.assertArrayEquals(byteArrayOf(-1, -1, -1, 127), Int.MAX_VALUE.toBigInteger().toBytes(Endian.LITTLE_ENDIAN))
    }

    @Test
    fun negativeBigIntegerLittleEndian() {
        Assertions.assertArrayEquals(byteArrayOf(0, 0, 0, -128), Int.MIN_VALUE.toBigInteger().toBytes(Endian.LITTLE_ENDIAN))
    }
}