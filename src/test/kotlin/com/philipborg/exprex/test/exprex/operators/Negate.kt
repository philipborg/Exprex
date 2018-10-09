package com.philipborg.exprex.test.exprex.operators

import com.philipborg.exprex.operators.NegateExprex
import com.philipborg.exprex.toValueExprex
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Negate {
    @Test
    fun negatePositive() {
        var negateExprex = NegateExprex(1.toValueExprex())
        Assertions.assertEquals((-1).toBigInteger(), negateExprex())
    }

    @Test
    fun negateNegative() {
        var negateExprex = NegateExprex((-1).toValueExprex())
        Assertions.assertEquals(1.toBigInteger(), negateExprex())
    }
}