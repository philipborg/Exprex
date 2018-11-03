package com.philipborg.exprex.operators

import com.philipborg.exprex.Exprex
import com.philipborg.exprex.math.RoundingMode
import com.philipborg.exprex.math.div
import java.math.BigInteger

data class DivisionExprex(val dividend: Exprex, val divisor: Exprex, val rounding: RoundingMode) : Exprex {
    override fun invoke(vararg input: BigInteger): BigInteger = dividend(*input).div(divisor(*input), rounding)
}