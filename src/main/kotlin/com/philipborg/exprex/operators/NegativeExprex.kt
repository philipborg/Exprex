package com.philipborg.exprex.operators

import com.philipborg.exprex.Exprex
import com.philipborg.exprex.Unary
import java.math.BigInteger

class NegativeExprex(child: Exprex) : Unary(child) {
    override fun invoke(vararg input: BigInteger): BigInteger {
        var result = child(*input)
        return when (result.signum()) {
            1 -> -result
            else -> result
        }
    }
}