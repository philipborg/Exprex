package com.philipborg.exprex.operators

import com.philipborg.exprex.Exprex
import com.philipborg.exprex.ParentOfTwo
import java.math.BigInteger

class Multiplication(childOne: Exprex, childTwo: Exprex) : ParentOfTwo(childOne, childTwo) {
    override fun invoke(input: Sequence<BigInteger>): BigInteger = childOne(input) * childTwo(input)
}