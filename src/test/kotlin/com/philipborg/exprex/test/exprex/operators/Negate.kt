package com.philipborg.exprex.test.exprex.operators

import com.philipborg.exprex.nodes.NegateNode
import com.philipborg.exprex.toValueNode
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Negate {
    @Test
    fun negatePositive() {
        var negateNode = NegateNode(1.toValueNode())
        Assertions.assertEquals((-1).toBigInteger(), negateNode())
    }

    @Test
    fun negateNegative() {
        var negateNode = NegateNode((-1).toValueNode())
        Assertions.assertEquals(1.toBigInteger(), negateNode())
    }
}