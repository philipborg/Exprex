package com.philipborg.exprex.test.encoding

import com.philipborg.exprex.encoding.asSingleVLQ
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import java.math.BigInteger

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class VLQDecoding {
    @Test
    fun zeroFromVLQUnsigned() {
        Assertions.assertEquals(BigInteger.ZERO, byteArrayOf(0).asSingleVLQ(false))
    }

    @Test
    fun zeroFromVLQSigned() {
        Assertions.assertEquals(BigInteger.ZERO, byteArrayOf(0).asSingleVLQ(true))
    }

    @Test
    fun oneFromVLQUnsigned() {
        Assertions.assertEquals(BigInteger.ONE, byteArrayOf(1).asSingleVLQ(false))
    }

    @Test
    fun oneFromVLQSigned() {
        Assertions.assertEquals(BigInteger.ONE, byteArrayOf(1).asSingleVLQ(true))
    }

    @Test
    fun negativeOneFromVLQ() {
        Assertions.assertEquals(-BigInteger.ONE, byteArrayOf(65).asSingleVLQ(true))
    }

    @Test
    fun biggerPositiveNumber() {
        Assertions.assertEquals(
                106903.toBigInteger(),
                byteArrayOf(-122, -61, 23).asSingleVLQ(false)
        )
    }

    @Test
    fun biggerNegativeToVLQ() {
        Assertions.assertEquals(
                (-106903).toBigInteger(),
                byteArrayOf(-58, -61, 23).asSingleVLQ(true)
        )
    }
}