package com.philipborg.exprex.test.encoding

import com.philipborg.exprex.encoding.firstVLQ
import com.philipborg.exprex.encoding.singleVLQ
import com.philipborg.exprex.encoding.toVLQ
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import java.math.BigInteger

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class VLQDecoding {
    @Test
    fun zeroFromVLQUnsigned() {
        Assertions.assertEquals(BigInteger.ZERO, byteArrayOf(0).singleVLQ(false))
    }

    @Test
    fun zeroFromVLQSigned() {
        Assertions.assertEquals(BigInteger.ZERO, byteArrayOf(0).singleVLQ(true))
    }

    @Test
    fun oneFromVLQUnsigned() {
        Assertions.assertEquals(BigInteger.ONE, byteArrayOf(1).singleVLQ(false))
    }

    @Test
    fun oneFromVLQSigned() {
        Assertions.assertEquals(BigInteger.ONE, byteArrayOf(1).singleVLQ(true))
    }

    @Test
    fun negativeOneFromVLQ() {
        Assertions.assertEquals(-BigInteger.ONE, byteArrayOf(65).singleVLQ(true))
    }

    @Test
    fun biggerPositiveNumber() {
        Assertions.assertEquals(
                106903.toBigInteger(),
                byteArrayOf(-122, -61, 23).singleVLQ(false)
        )
    }

    @Test
    fun biggerNegativeToVLQ() {
        Assertions.assertEquals(
                (-106903).toBigInteger(),
                byteArrayOf(-58, -61, 23).singleVLQ(true)
        )
    }

    @Test
    fun firstVLQUnsigned() {
        val series = 106903.toVLQ(false)
        Assertions.assertEquals(
                series.singleVLQ(false),
                (series + series).firstVLQ(false)
        )
    }

    @Test
    fun firstVLQSigned() {
        val series = (-106903).toVLQ(true)
        Assertions.assertEquals(
                series.singleVLQ(true),
                (series + series).firstVLQ(true)
        )
    }

    @Test
    fun singleOverflowUnsigned() {
        val series = 106903.toVLQ(false)
        Assertions.assertThrows(IllegalArgumentException::class.java)
        {
            (series + series).singleVLQ(false)
        }
    }

    @Test
    fun singleOverflowSigned() {
        val series = (-106903).toVLQ(true)
        Assertions.assertThrows(IllegalArgumentException::class.java)
        {
            (series + series).singleVLQ(true)
        }
    }
}