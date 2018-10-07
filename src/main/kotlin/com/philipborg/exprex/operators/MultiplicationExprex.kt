package com.philipborg.exprex.operators

import com.philipborg.exprex.Binary
import com.philipborg.exprex.Exprex
import java.math.BigInteger

class MultiplicationExprex(multiplier: Exprex, multiplicand: Exprex) : Binary(multiplier, multiplicand) {
    override fun invoke(vararg input: BigInteger): BigInteger = childOne(*input) * childTwo(*input)
}