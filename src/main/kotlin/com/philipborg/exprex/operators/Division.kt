package com.philipborg.exprex.operators

import com.philipborg.exprex.Exprex
import com.philipborg.exprex.ParentOfTwo
import java.math.BigInteger
import java.math.RoundingMode

class Division(childOne: Exprex, childTwo: Exprex, private val roundingMode: RoundingMode) : ParentOfTwo(childOne, childTwo) {
    override fun invoke(input: Sequence<BigInteger>): BigInteger {
        TODO()
    }
}