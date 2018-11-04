package com.philipborg.exprex.nodes

import com.philipborg.exprex.ExpressionNode
import com.philipborg.exprex.math.RoundingMode
import com.philipborg.exprex.math.div
import java.math.BigInteger

data class DivisionNode(val dividend: ExpressionNode, val divisor: ExpressionNode, val rounding: RoundingMode) : ExpressionNode {
    override fun invoke(vararg input: BigInteger): BigInteger = dividend(*input).div(divisor(*input), rounding)
}