package com.philipborg.exprex.test.exprex

import com.philipborg.exprex.operators.ModulusExprex
import com.philipborg.exprex.toValueExprex
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.function.Executable

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Modulus {
    @Test
    fun simpleModulus() {
        Assertions.assertAll(
                arrayOf(
                        Scenario(1, 1, 0),
                        Scenario(1, 2, 1),
                        Scenario(1, -1, 0),
                        Scenario(-1, -2, -1),
                        Scenario(2, -3, 2),
                        Scenario(10, 3, 1)
                ).map {
                    Executable {
                        Assertions.assertEquals(it.remainder.toBigInteger(), ModulusExprex(it.dividend.toValueExprex(), it.divisor.toValueExprex()).invoke(), it.toString())
                    }
                }
        )
        Assertions.assertThrows(ArithmeticException::class.java, { ModulusExprex(1.toValueExprex(), 0.toValueExprex()).invoke() }, "One modulus zero")
    }

    data class Scenario(val dividend: Int, val divisor: Int, val remainder: Int)
}