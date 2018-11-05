package com.philipborg.exprex.test.math

import com.philipborg.exprex.math.toBigInteger
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import java.math.BigInteger

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ToBigInteger {
    @ExperimentalUnsignedTypes
    @Test
    fun positive() {
        Assertions.assertEquals(BigInteger.TEN, 10.toByte().toBigInteger())
        Assertions.assertEquals(BigInteger.TEN, 10.toUByte().toBigInteger())

        Assertions.assertEquals(BigInteger.TEN, 10.toShort().toBigInteger())
        Assertions.assertEquals(BigInteger.TEN, 10.toUShort().toBigInteger())

        Assertions.assertEquals(BigInteger.TEN, 10.toBigInteger())
        Assertions.assertEquals(BigInteger.TEN, 10.toUInt().toBigInteger())

        Assertions.assertEquals(BigInteger.TEN, 10.toLong().toBigInteger())
        Assertions.assertEquals(BigInteger.TEN, 10.toULong().toBigInteger())
    }

    @Test
    fun negative() {
        Assertions.assertEquals(-BigInteger.TEN, (-10).toByte().toBigInteger())
        Assertions.assertEquals(-BigInteger.TEN, (-10).toShort().toBigInteger())
        Assertions.assertEquals(-BigInteger.TEN, (-10).toBigInteger())
        Assertions.assertEquals(-BigInteger.TEN, (-10).toLong().toBigInteger())
    }

    @ExperimentalUnsignedTypes
    @Test
    fun maxValue() {
        Assertions.assertEquals(BigInteger.valueOf(Byte.MAX_VALUE.toLong()), Byte.MAX_VALUE.toBigInteger())
        Assertions.assertEquals(BigInteger.valueOf(UByte.MAX_VALUE.toLong()), UByte.MAX_VALUE.toBigInteger())

        Assertions.assertEquals(BigInteger.valueOf(Short.MAX_VALUE.toLong()), Short.MAX_VALUE.toBigInteger())
        Assertions.assertEquals(BigInteger.valueOf(UShort.MAX_VALUE.toLong()), UShort.MAX_VALUE.toBigInteger())

        Assertions.assertEquals(BigInteger.valueOf(Int.MAX_VALUE.toLong()), Int.MAX_VALUE.toBigInteger())
        Assertions.assertEquals(BigInteger.valueOf(UInt.MAX_VALUE.toLong()), UInt.MAX_VALUE.toBigInteger())

        Assertions.assertEquals(BigInteger.valueOf(Long.MAX_VALUE), Long.MAX_VALUE.toBigInteger())
        Assertions.assertEquals(BigInteger("18446744073709551615", 10), ULong.MAX_VALUE.toBigInteger())
    }

    @ExperimentalUnsignedTypes
    @Test
    fun minValue() {
        Assertions.assertEquals(BigInteger.valueOf(Byte.MIN_VALUE.toLong()), Byte.MIN_VALUE.toBigInteger())
        Assertions.assertEquals(BigInteger.ZERO, UByte.MIN_VALUE.toBigInteger())

        Assertions.assertEquals(BigInteger.valueOf(Short.MIN_VALUE.toLong()), Short.MIN_VALUE.toBigInteger())
        Assertions.assertEquals(BigInteger.ZERO, UShort.MIN_VALUE.toBigInteger())

        Assertions.assertEquals(BigInteger.valueOf(Int.MIN_VALUE.toLong()), Int.MIN_VALUE.toBigInteger())
        Assertions.assertEquals(BigInteger.ZERO, UInt.MIN_VALUE.toBigInteger())

        Assertions.assertEquals(BigInteger.valueOf(Long.MIN_VALUE), Long.MIN_VALUE.toBigInteger())
        Assertions.assertEquals(BigInteger.ZERO, ULong.MIN_VALUE.toBigInteger())
    }
}