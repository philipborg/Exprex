package com.philipborg.exprex

import java.math.BigInteger

class ValueExprex(val value: BigInteger) : Exprex {
    override fun invoke(input: Sequence<BigInteger>): BigInteger = value
}