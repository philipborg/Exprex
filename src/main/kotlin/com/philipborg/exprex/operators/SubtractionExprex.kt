package com.philipborg.exprex.operators

import com.philipborg.exprex.Binary
import com.philipborg.exprex.Exprex
import java.math.BigInteger

class SubtractionExprex(minuend: Exprex, subtrahend: Exprex) : Binary(minuend, subtrahend) {
    override fun invoke(vararg input: BigInteger): BigInteger = childOne(*input) - childTwo(*input)
}