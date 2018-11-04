package com.philipborg.exprex.test.exprex.operators

import com.philipborg.exprex.math.RoundingMode
import com.philipborg.exprex.nodes.DivisionNode
import com.philipborg.exprex.toValueNode
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
                        Assertions.assertEquals(it.quotient.toBigInteger(), DivisionNode(it.dividend.toValueNode(), it.divisor.toValueNode(), it.roundingMode).invoke(), it.toString())
                    }
                }
        )
        Assertions.assertThrows(ArithmeticException::class.java, { DivisionNode(1.toValueNode(), 0.toValueNode(), RoundingMode.UNNECESSARY).invoke() }, "One divided by zero")
        Assertions.assertThrows(ArithmeticException::class.java, { DivisionNode(3.toValueNode(), 2.toValueNode(), RoundingMode.UNNECESSARY).invoke() }, "Three divided by two RoundingMode='${RoundingMode.UNNECESSARY.name}'")
    }

    data class Scenario(val dividend: Int, val divisor: Int, val roundingMode: RoundingMode, val quotient: Int)
}