package com.philipborg.exprex.test.exprex.operators

import com.philipborg.exprex.nodes.AdditionNode
import com.philipborg.exprex.toValueNode
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.function.Executable

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Addition {
    @Test
    fun simpleAdd() {
        Assertions.assertAll(
                arrayOf(
                        Scenario(1, 1, 2),
                        Scenario(1, 2, 3),
                        Scenario(0, 0, 0),
                        Scenario(1, -1, 0),
                        Scenario(-1, -2, -3),
                        Scenario(2, -3, -1)
                ).map {
                    Executable {
                        Assertions.assertEquals(it.sum.toBigInteger(), AdditionNode(it.augend.toValueNode(), it.addend.toValueNode()).invoke(), it.toString())
                    }
                }
        )
    }

    data class Scenario(val augend: Int, val addend: Int, val sum: Int)
}