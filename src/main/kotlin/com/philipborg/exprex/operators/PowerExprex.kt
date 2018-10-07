package com.philipborg.exprex.operators

import com.philipborg.exprex.BinaryRounding
import com.philipborg.exprex.Exprex
import com.philipborg.exprex.math.power
import java.math.BigInteger
import java.math.RoundingMode

class PowerExprex(base: Exprex, exponent: Exprex, rounding: RoundingMode) : BinaryRounding(base, exponent, rounding) {
    override fun invoke(vararg input: BigInteger): BigInteger = childOne().power(childTwo(), rounding)
}