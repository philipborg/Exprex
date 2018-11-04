package com.philipborg.exprex.test.exprex.operators

import com.philipborg.exprex.VariableNode
import com.philipborg.exprex.exceptions.MissingParameterException
import com.philipborg.exprex.nodes.AdditionNode
import com.philipborg.exprex.nodes.SubtractionNode
import com.philipborg.exprex.toValueNode
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Variable {

    @Test
    fun skippingParameters() {
        val params = arrayOf(1, 2, 3, 4).map { it.toBigInteger() }.toTypedArray()
        val augend = VariableNode(1)
        val addend = VariableNode(2)

        val additionNode = AdditionNode(augend, addend)
        Assertions.assertEquals(5.toBigInteger(), additionNode(*params))
    }

    @Test
    fun negativeParameters() {
        val minuend = VariableNode(0)
        val subtrahend = 2.toValueNode()

        val subtractionNode = SubtractionNode(minuend, subtrahend)
        Assertions.assertEquals(2.toBigInteger(), subtractionNode(4.toBigInteger()))
    }

    @Test
    fun missingParameter() {
        val augend = VariableNode(1)
        val addend = VariableNode(0)

        val additionNode = AdditionNode(augend, addend)

        Assertions.assertThrows(MissingParameterException::class.java) { additionNode(1.toBigInteger()) }
    }

    @Test
    fun illegalParameter() {
        Assertions.assertThrows(MissingParameterException::class.java) { VariableNode(-1) }
    }
}