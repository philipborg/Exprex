package com.philipborg.exprex.operators

import com.philipborg.exprex.Exprex
import java.math.BigInteger

data class MultiplicationExprex(val multiplier: Exprex, val multiplicand: Exprex) : Exprex {
    override fun invoke(vararg input: BigInteger): BigInteger = multiplier(*input) * multiplicand(*input)
}