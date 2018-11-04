package com.philipborg.exprex.test.exprex.operators

import com.philipborg.exprex.nodes.ModulusNode
import com.philipborg.exprex.toValueNode
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
                        Assertions.assertEquals(it.remainder.toBigInteger(), ModulusNode(it.dividend.toValueNode(), it.divisor.toValueNode()).invoke(), it.toString())
                    }
                }
        )
        Assertions.assertThrows(ArithmeticException::class.java, { ModulusNode(1.toValueNode(), 0.toValueNode()).invoke() }, "One modulus zero")
    }

    data class Scenario(val dividend: Int, val divisor: Int, val remainder: Int)
}