package com.philipborg.exprex.test.util

import com.philipborg.exprex.util.takeWhileIncludingLast
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TakeWhileIncluding {
    @Test
    fun empty() {
        Assertions.assertTrue(listOf<Any>().takeWhileIncludingLast { true }.none())
    }

    @Test
    fun everything() {
        val data = listOf(1, 2, 3, 4, 5)
        Assertions.assertArrayEquals(
                data.toIntArray(),
                data.takeWhileIncludingLast { true }.toIntArray()
        )
    }

    @Test
    fun some() {
        Assertions.assertArrayEquals(
                intArrayOf(1, 2, 3),
                listOf(1, 2, 3, 4, 5).takeWhileIncludingLast { it < 3 }.toIntArray()
        )
    }

    @Test
    fun first() {
        Assertions.assertArrayEquals(
                intArrayOf(1),
                listOf(1, 2, 3, 4, 5).takeWhileIncludingLast { false }.toIntArray()
        )
    }
}