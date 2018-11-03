package com.philipborg.exprex.operators

import com.philipborg.exprex.Exprex
import java.math.BigInteger

data class ModulusExprex(val dividend: Exprex, val divisor: Exprex) : Exprex {
    override fun invoke(vararg input: BigInteger): BigInteger = dividend(*input) % divisor(*input)
}