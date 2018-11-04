package com.philipborg.exprex.test.exprex.operators

import com.philipborg.exprex.nodes.PositiveNode
import com.philipborg.exprex.toValueNode
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import java.math.BigInteger

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Positive {
    @Test
    fun positive() {
        val positiveNode = PositiveNode(1.toValueNode())
        Assertions.assertEquals(BigInteger.ONE, positiveNode())
    }

    @Test
    fun negative() {
        val positiveNode = PositiveNode((-1).toValueNode())
        Assertions.assertEquals(BigInteger.ONE, positiveNode())
    }

    @Test
    fun zero() {
        val positiveNode = PositiveNode(0.toValueNode())
        Assertions.assertEquals(BigInteger.ZERO, positiveNode())
    }
}