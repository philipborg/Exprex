package com.philipborg.exprex

import com.philipborg.exprex.exceptions.MissingParameterException
import java.math.BigInteger

data class VariableNode(val parameter: Int) : ExpressionNode {

    init {
        if (parameter < 0)
            throw MissingParameterException(parameter, "Parameter $parameter can never be sent as it is below 0")
    }

    override fun invoke(vararg input: BigInteger): BigInteger {
        try {
            return input[parameter]
        } catch (e: IndexOutOfBoundsException) {
            throw MissingParameterException(parameter = parameter, cause = e)
        }
    }
}