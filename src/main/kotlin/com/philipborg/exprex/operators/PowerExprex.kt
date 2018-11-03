package com.philipborg.exprex.operators

import com.philipborg.exprex.Exprex
import com.philipborg.exprex.math.RoundingMode
import com.philipborg.exprex.math.power
import java.math.BigInteger

data class PowerExprex(val base: Exprex, val exponent: Exprex, val rounding: RoundingMode) : Exprex {
    override fun invoke(vararg input: BigInteger): BigInteger = base(*input).power(exponent(*input), rounding)
}