package com.philipborg.exprex.operators

import com.philipborg.exprex.BinaryRounding
import com.philipborg.exprex.Exprex
import com.philipborg.exprex.math.div
import java.math.BigInteger
import java.math.RoundingMode

class DivisionExprex(dividend: Exprex, divisor: Exprex, rounding: RoundingMode) : BinaryRounding(dividend, divisor, rounding) {
    override fun invoke(vararg input: BigInteger): BigInteger = childOne(*input).div(childTwo(*input), rounding)
}