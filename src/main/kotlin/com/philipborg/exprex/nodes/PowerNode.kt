package com.philipborg.exprex.nodes

import com.philipborg.exprex.ExpressionNode
import com.philipborg.exprex.math.RoundingMode
import com.philipborg.exprex.math.power
import java.math.BigInteger

data class PowerNode(val base: ExpressionNode, val exponent: ExpressionNode, val rounding: RoundingMode) : ExpressionNode {
    override fun invoke(vararg input: BigInteger): BigInteger = base(*input).power(exponent(*input), rounding)
}