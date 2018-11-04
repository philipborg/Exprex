package com.philipborg.exprex.nodes

import com.philipborg.exprex.ExpressionNode
import java.math.BigInteger

data class SubtractionNode(val minuend: ExpressionNode, val subtrahend: ExpressionNode) : ExpressionNode {
    override fun invoke(vararg input: BigInteger): BigInteger = minuend(*input) - subtrahend(*input)
}