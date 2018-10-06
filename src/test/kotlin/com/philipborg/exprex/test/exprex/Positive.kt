package com.philipborg.exprex.test.exprex

import com.philipborg.exprex.operators.PositiveExprex
import com.philipborg.exprex.toValueExprex
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import java.math.BigInteger

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Positive {
    @Test
    fun positive() {
        val positiveExprex = PositiveExprex(1.toValueExprex())
        Assertions.assertEquals(BigInteger.ONE, positiveExprex())
    }

    @Test
    fun negative() {
        val positiveExprex = PositiveExprex((-1).toValueExprex())
        Assertions.assertEquals(BigInteger.ONE, positiveExprex())
    }

    @Test
    fun zero() {
        val positiveExprex = PositiveExprex(0.toValueExprex())
        Assertions.assertEquals(BigInteger.ZERO, positiveExprex())
    }
}