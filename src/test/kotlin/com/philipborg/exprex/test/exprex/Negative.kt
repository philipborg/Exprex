package com.philipborg.exprex.test.exprex

import com.philipborg.exprex.operators.NegativeExprex
import com.philipborg.exprex.toValueExprex
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import java.math.BigInteger

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Negative {
    @Test
    fun positive() {
        val negativeExprex = NegativeExprex(1.toValueExprex())
        Assertions.assertEquals((-1).toBigInteger(), negativeExprex())
    }

    @Test
    fun negative() {
        val negativeExprex = NegativeExprex((-1).toValueExprex())
        Assertions.assertEquals((-1).toBigInteger(), negativeExprex())
    }

    @Test
    fun zero() {
        val negativeExprex = NegativeExprex(0.toValueExprex())
        Assertions.assertEquals(BigInteger.ZERO, negativeExprex())
    }
}