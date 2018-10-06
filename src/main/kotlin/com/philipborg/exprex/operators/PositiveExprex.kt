package com.philipborg.exprex.operators

import com.philipborg.exprex.Exprex
import com.philipborg.exprex.ParentOfOne
import java.math.BigInteger

class PositiveExprex(child: Exprex) : ParentOfOne(child) {
    override fun invoke(vararg input: BigInteger): BigInteger = child(*input).abs()
}