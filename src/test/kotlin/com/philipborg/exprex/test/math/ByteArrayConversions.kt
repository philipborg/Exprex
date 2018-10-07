package com.philipborg.exprex.test.math

import com.philipborg.exprex.math.Endian
import com.philipborg.exprex.math.toBytes
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ByteArrayConversions {
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
}