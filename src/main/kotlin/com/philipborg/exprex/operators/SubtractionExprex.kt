package com.philipborg.exprex.operators

import com.philipborg.exprex.Exprex
import java.math.BigInteger

data class SubtractionExprex(val minuend: Exprex, val subtrahend: Exprex) : Exprex {
    override fun invoke(vararg input: BigInteger): BigInteger = minuend(*input) - subtrahend(*input)
}