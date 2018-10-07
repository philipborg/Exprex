package com.philipborg.exprex.operators

import com.philipborg.exprex.Binary
import com.philipborg.exprex.Exprex
import java.math.BigInteger

class AdditionExprex(augend: Exprex, addend: Exprex) : Binary(augend, addend) {
    override fun invoke(vararg input: BigInteger): BigInteger = childOne(*input) + (childTwo(*input))
}