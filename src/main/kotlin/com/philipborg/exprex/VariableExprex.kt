package com.philipborg.exprex

import java.math.BigInteger

class VariableExprex(val parameter: Int) : Exprex {
    override fun invoke(input: Sequence<BigInteger>): BigInteger = input.elementAt(parameter)
}