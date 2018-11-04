package com.philipborg.exprex.nodes

import com.philipborg.exprex.ExpressionNode
import java.math.BigInteger

data class AdditionNode(val augend: ExpressionNode, val addend: ExpressionNode) : ExpressionNode {
    override fun invoke(vararg input: BigInteger): BigInteger = augend(*input) + addend(*input)
}