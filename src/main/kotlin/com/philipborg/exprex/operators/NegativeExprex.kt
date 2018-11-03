package com.philipborg.exprex.operators

import com.philipborg.exprex.Exprex
import java.math.BigInteger

data class NegativeExprex(val child: Exprex) : Exprex {
    override fun invoke(vararg input: BigInteger): BigInteger {
        var result = child(*input)
        return when (result.signum()) {
            1 -> -result
            else -> result
        }
    }
}