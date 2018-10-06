package com.philipborg.exprex.operators

import com.philipborg.exprex.Exprex
import com.philipborg.exprex.ParentOfTwo
import com.philipborg.exprex.math.div
import java.math.BigInteger
import java.math.RoundingMode

class Division(dividend: Exprex, divisor: Exprex, private val roundingMode: RoundingMode) : ParentOfTwo(dividend, divisor) {
    override fun invoke(input: Sequence<BigInteger>): BigInteger = childOne(input).div(childTwo(input), roundingMode)
}