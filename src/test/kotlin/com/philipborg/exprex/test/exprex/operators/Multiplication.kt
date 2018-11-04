package com.philipborg.exprex.test.exprex.operators

import com.philipborg.exprex.nodes.MultiplicationNode
import com.philipborg.exprex.toValueNode
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.function.Executable

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Multiplication {

    @Test
    fun simpleMultiplication() {
        Assertions.assertAll(
                arrayOf(
                        Scenario(1, 1, 1),
                        Scenario(1, 0, 0),
                        Scenario(0, 1, 0),
                        Scenario(0, 0, 0),
                        Scenario(-10, 2, -20),
                        Scenario(-10, -10, 100)
                ).map {
                    Executable {
                        Assertions.assertEquals(it.product.toBigInteger(), MultiplicationNode(it.multiplier.toValueNode(), it.multiplicand.toValueNode()).invoke(), it.toString())
                    }
                }
        )
    }

    data class Scenario(val multiplier: Int, val multiplicand: Int, val product: Int)
}