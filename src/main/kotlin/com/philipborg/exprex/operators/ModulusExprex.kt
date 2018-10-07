package com.philipborg.exprex.operators

import com.philipborg.exprex.Binary
import com.philipborg.exprex.Exprex
import java.math.BigInteger

class ModulusExprex(dividend: Exprex, divisor: Exprex) : Binary(dividend, divisor) {
    override fun invoke(vararg input: BigInteger): BigInteger = childOne(*input) % childTwo(*input)
}