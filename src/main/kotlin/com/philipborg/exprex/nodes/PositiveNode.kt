package com.philipborg.exprex.nodes

import com.philipborg.exprex.ExpressionNode
import java.math.BigInteger

data class PositiveNode(val child: ExpressionNode) : ExpressionNode {
    override fun invoke(vararg input: BigInteger): BigInteger = child(*input).abs()
}