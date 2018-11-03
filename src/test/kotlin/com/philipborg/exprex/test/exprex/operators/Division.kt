package com.philipborg.exprex.test.exprex.operators

import com.philipborg.exprex.math.RoundingMode
import com.philipborg.exprex.operators.DivisionExprex
import com.philipborg.exprex.toValueExprex
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.function.Executable

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Division {
    @Test
    fun simpleDivision() {
        Assertions.assertAll(
                arrayOf(
                        Scenario(10, 2, RoundingMode.UNNECESSARY, 5),
                        Scenario(5, 2, RoundingMode.HALF_DOWN, 2),
                        Scenario(-1, 2, RoundingMode.DOWN, 0),
                        Scenario(-5, -2, RoundingMode.HALF_EVEN, 2)
                ).map {
                    Executable {
                        Assertions.assertEquals(it.quotient.toBigInteger(), DivisionExprex(it.dividend.toValueExprex(), it.divisor.toValueExprex(), it.roundingMode).invoke(), it.toString())
                    }
                }
        )
        Assertions.assertThrows(ArithmeticException::class.java, { DivisionExprex(1.toValueExprex(), 0.toValueExprex(), RoundingMode.UNNECESSARY).invoke() }, "One divided by zero")
        Assertions.assertThrows(ArithmeticException::class.java, { DivisionExprex(3.toValueExprex(), 2.toValueExprex(), RoundingMode.UNNECESSARY).invoke() }, "Three divided by two RoundingMode='${RoundingMode.UNNECESSARY.name}'")
    }

    data class Scenario(val dividend: Int, val divisor: Int, val roundingMode: RoundingMode, val quotient: Int)
}