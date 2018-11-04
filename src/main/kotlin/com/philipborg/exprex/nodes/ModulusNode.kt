package com.philipborg.exprex.nodes

import com.philipborg.exprex.ExpressionNode
import java.math.BigInteger

data class ModulusNode(val dividend: ExpressionNode, val divisor: ExpressionNode) : ExpressionNode {
    override fun invoke(vararg input: BigInteger): BigInteger = dividend(*input) % divisor(*input)
}