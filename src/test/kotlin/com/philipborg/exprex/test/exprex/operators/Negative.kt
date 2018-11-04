package com.philipborg.exprex.test.exprex.operators

import com.philipborg.exprex.nodes.NegativeNode
import com.philipborg.exprex.toValueNode
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import java.math.BigInteger

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Negative {
    @Test
    fun positive() {
        val negativeNode = NegativeNode(1.toValueNode())
        Assertions.assertEquals((-1).toBigInteger(), negativeNode())
    }

    @Test
    fun negative() {
        val negativeNode = NegativeNode((-1).toValueNode())
        Assertions.assertEquals((-1).toBigInteger(), negativeNode())
    }

    @Test
    fun zero() {
        val negativeNode = NegativeNode(0.toValueNode())
        Assertions.assertEquals(BigInteger.ZERO, negativeNode())
    }
}