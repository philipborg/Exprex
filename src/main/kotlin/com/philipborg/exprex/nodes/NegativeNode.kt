package com.philipborg.exprex.nodes

import com.philipborg.exprex.ExpressionNode
import java.math.BigInteger

data class NegativeNode(val child: ExpressionNode) : ExpressionNode {
    override fun invoke(vararg input: BigInteger): BigInteger {
        var result = child(*input)
        return when (result.signum()) {
            1 -> -result
            else -> result
        }
    }
}