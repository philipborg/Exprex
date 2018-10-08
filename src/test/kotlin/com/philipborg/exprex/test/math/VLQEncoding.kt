package com.philipborg.exprex.test.math

import com.philipborg.exprex.math.toVLQ
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class VLQEncoding {
    @Test
    fun zeroToVLQUnsigned() {
        Assertions.assertArrayEquals(byteArrayOf(0), 0.toVLQ(false))
    }

    @Test
    fun zeroToVLQSigned() {
        Assertions.assertArrayEquals(byteArrayOf(0), 0.toVLQ(true))
    }

    @Test
    fun oneToVLQUnsigned() {
        Assertions.assertArrayEquals(byteArrayOf(1), 1.toVLQ(false))
    }

    @Test
    fun oneToVLQSigned() {
        Assertions.assertArrayEquals(byteArrayOf(1), 1.toVLQ(true))
    }

    @Test
    fun negativeOneToVLQ() {
        Assertions.assertArrayEquals(byteArrayOf(65), (-1).toVLQ(true))
    }

    @Test
    fun biggerPositiveNumber() {
        Assertions.assertArrayEquals(
                byteArrayOf(-122, -61, 23),
                106903.toVLQ(false)
        )
    }

    @Test
    fun biggerNegativeToVLQ() {
        Assertions.assertArrayEquals(
                byteArrayOf(-58, -61, 23),
                (-106903).toVLQ(true)
        )
    }
}