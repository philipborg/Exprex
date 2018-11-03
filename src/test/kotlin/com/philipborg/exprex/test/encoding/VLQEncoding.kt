package com.philipborg.exprex.test.encoding

import com.philipborg.exprex.encoding.toVLQ
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import java.math.BigInteger

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class VLQEncoding {
    @Test
    fun zeroUnsigned() {
        Assertions.assertArrayEquals(byteArrayOf(0), 0.toVLQ(false))
    }

    @Test
    fun zeroSigned() {
        Assertions.assertArrayEquals(byteArrayOf(0), 0.toVLQ(true))
    }

    @Test
    fun oneUnsigned() {
        Assertions.assertArrayEquals(byteArrayOf(1), 1.toVLQ(false))
    }

    @Test
    fun oneSigned() {
        Assertions.assertArrayEquals(byteArrayOf(1), 1.toVLQ(true))
    }

    @Test
    fun negativeOne() {
        Assertions.assertArrayEquals(byteArrayOf(65), (-1).toVLQ(true))
    }

    @Test
    fun biggerPositive() {
        Assertions.assertArrayEquals(
                byteArrayOf(-122, -61, 23),
                106903.toVLQ(false)
        )
    }

    @Test
    fun biggerNegative() {
        Assertions.assertArrayEquals(
                byteArrayOf(-58, -61, 23),
                (-106903).toVLQ(true)
        )
    }

    @Test
    fun signError() {
        Assertions.assertThrows(IllegalArgumentException::class.java)
        {
            (-BigInteger.ONE).toVLQ(false)
        }
    }
}