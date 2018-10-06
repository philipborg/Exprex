package com.philipborg.exprex.operators

import com.philipborg.exprex.Exprex
import com.philipborg.exprex.ParentOfTwo
import java.math.BigInteger

class ModulusExprex(dividend: Exprex, divisor: Exprex) : ParentOfTwo(dividend, divisor) {
    override fun invoke(vararg input: BigInteger): BigInteger = childOne(*input) % childTwo(*input)
}