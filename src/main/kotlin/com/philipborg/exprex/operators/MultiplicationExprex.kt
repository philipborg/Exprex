package com.philipborg.exprex.operators

import com.philipborg.exprex.Exprex
import com.philipborg.exprex.ParentOfTwo
import java.math.BigInteger

class MultiplicationExprex(multiplier: Exprex, multiplicand: Exprex) : ParentOfTwo(multiplier, multiplicand) {
    override fun invoke(vararg input: BigInteger): BigInteger = childOne(*input) * childTwo(*input)
}