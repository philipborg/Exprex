package com.philipborg.exprex.operators

import com.philipborg.exprex.Exprex
import com.philipborg.exprex.Unary
import java.math.BigInteger

class PositiveExprex(child: Exprex) : Unary(child) {
    override fun invoke(vararg input: BigInteger): BigInteger = child(*input).abs()
}