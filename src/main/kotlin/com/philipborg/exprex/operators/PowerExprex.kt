package com.philipborg.exprex.operators

import com.philipborg.exprex.Exprex
import com.philipborg.exprex.ParentOfTwo
import com.philipborg.exprex.math.power
import java.math.BigInteger
import java.math.RoundingMode

class PowerExprex(base: Exprex, exponent: Exprex, private val roundingMode: RoundingMode) : ParentOfTwo(base, exponent) {
    override fun invoke(vararg input: BigInteger): BigInteger = childOne().power(childTwo(), roundingMode)
}