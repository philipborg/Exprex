package com.philipborg.exprex.test.exprex.operators

import com.philipborg.exprex.operators.SubtractionExprex
import com.philipborg.exprex.toValueExprex
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.function.Executable


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Subtraction {
    @Test
    fun simpleSubtraction() {
        Assertions.assertAll(
                arrayOf(
                        Scenario(1, 1, 0),
                        Scenario(1, 2, -1),
                        Scenario(0, 0, 0),
                        Scenario(1, -1, 2),
                        Scenario(-1, -2, 1),
                        Scenario(2, -3, 5)
                ).map {
                    Executable {
                        Assertions.assertEquals(it.difference.toBigInteger(), SubtractionExprex(it.minuend.toValueExprex(), it.subtrahend.toValueExprex()).invoke(), it.toString())
                    }
                }
        )
    }

    data class Scenario(val minuend: Int, val subtrahend: Int, val difference: Int)
}