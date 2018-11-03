package com.philipborg.exprex.operators

import com.philipborg.exprex.Exprex
import java.math.BigInteger

data class NegateExprex(val child: Exprex) : Exprex {
    override fun invoke(vararg input: BigInteger): BigInteger = child(*input).negate()
}