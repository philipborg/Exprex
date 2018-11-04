package com.philipborg.exprex.nodes

import com.philipborg.exprex.ExpressionNode
import java.math.BigInteger

data class MultiplicationNode(val multiplier: ExpressionNode, val multiplicand: ExpressionNode) : ExpressionNode {
    override fun invoke(vararg input: BigInteger): BigInteger = multiplier(*input) * multiplicand(*input)
}