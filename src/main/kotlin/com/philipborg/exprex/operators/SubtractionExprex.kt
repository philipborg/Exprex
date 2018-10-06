package com.philipborg.exprex.operators

import com.philipborg.exprex.Exprex
import com.philipborg.exprex.ParentOfTwo
import java.math.BigInteger

class SubtractionExprex(minuend: Exprex, subtrahend: Exprex) : ParentOfTwo(minuend, subtrahend) {
    override fun invoke(input: Sequence<BigInteger>): BigInteger = childOne(input) - childTwo(input)
}