package com.philipborg.exprex.operators

import com.philipborg.exprex.Exprex
import com.philipborg.exprex.ParentOfTwo
import java.math.BigInteger

class Modulus(dividend: Exprex, divisor: Exprex) : ParentOfTwo(dividend, divisor) {
    override fun invoke(input: Sequence<BigInteger>): BigInteger = childOne(input) % childTwo(input)
}