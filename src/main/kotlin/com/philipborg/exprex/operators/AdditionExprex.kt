package com.philipborg.exprex.operators

import com.philipborg.exprex.Exprex
import com.philipborg.exprex.ParentOfTwo
import java.math.BigInteger

class AdditionExprex(augend: Exprex, addend: Exprex) : ParentOfTwo(augend, addend) {
    override fun invoke(input: Sequence<BigInteger>): BigInteger = childOne(input) + (childTwo(input))
}