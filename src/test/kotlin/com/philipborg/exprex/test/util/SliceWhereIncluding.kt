package com.philipborg.exprex.test.util

import com.philipborg.exprex.util.sliceWhereIncluding
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SliceWhereIncluding {
    @Test
    fun empty() {
        Assertions.assertTrue(
                listOf<Any>().sliceWhereIncluding { true }.none()
        )
    }

    @Test
    fun noSlice() {
        Assertions.assertArrayEquals(
                intArrayOf(1, 2, 3, 4, 5),
                listOf(1, 2, 3, 4, 5).sliceWhereIncluding { false }.single().toIntArray()
        )
    }

    @Test
    fun sliceOnEven() {
        Assertions.assertArrayEquals(
                arrayOf(
                        intArrayOf(1, 2),
                        intArrayOf(3, 4),
                        intArrayOf(5)
                ),
                listOf(1, 2, 3, 4, 5).sliceWhereIncluding { it and 0x01 == 0 }.map { it.toIntArray() }.toTypedArray()
        )
    }

    @Test
    fun single() {
        Assertions.assertArrayEquals(
                intArrayOf(1),
                listOf(1).sliceWhereIncluding { true }.single().toIntArray()
        )
    }
}