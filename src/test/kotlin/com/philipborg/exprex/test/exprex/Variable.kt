package com.philipborg.exprex.test.exprex

import com.philipborg.exprex.VariableExprex
import com.philipborg.exprex.exceptions.MissingParameterException
import com.philipborg.exprex.operators.AdditionExprex
import com.philipborg.exprex.operators.SubtractionExprex
import com.philipborg.exprex.toValueExprex
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Variable {

    @Test
    fun skippingParameters() {
        val params = arrayOf(1, 2, 3, 4).map { it.toBigInteger() }.toTypedArray()
        val augend = VariableExprex(1)
        val addend = VariableExprex(2)

        val additionExprex = AdditionExprex(augend, addend)
        Assertions.assertEquals(5.toBigInteger(), additionExprex(*params))
    }

    @Test
    fun negativeParameters() {
        val minuend = VariableExprex(0)
        val subtrahend = 2.toValueExprex()

        val subtractionExprex = SubtractionExprex(minuend, subtrahend)
        Assertions.assertEquals(2.toBigInteger(), subtractionExprex(4.toBigInteger()))
    }

    @Test
    fun missingParameter() {
        val augend = VariableExprex(1)
        val addend = VariableExprex(0)

        val additionExprex = AdditionExprex(augend, addend)

        Assertions.assertThrows(MissingParameterException::class.java) { additionExprex(1.toBigInteger()) }
    }

    @Test
    fun illegalParameter() {
        Assertions.assertThrows(MissingParameterException::class.java) { VariableExprex(-1) }
    }
}