package com.philipborg.exprex

import java.math.BigInteger

class VariableExprex(val parameter: Int) : Exprex {
    override fun invoke(vararg input: BigInteger): BigInteger = input[parameter]
}