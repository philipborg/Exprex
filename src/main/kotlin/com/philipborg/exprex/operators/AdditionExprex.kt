package com.philipborg.exprex.operators

import com.philipborg.exprex.Exprex
import java.math.BigInteger

data class AdditionExprex(val augend: Exprex, val addend: Exprex) : Exprex {
    override fun invoke(vararg input: BigInteger): BigInteger = augend(*input) + addend(*input)
}