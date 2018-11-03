package com.philipborg.exprex

import com.philipborg.exprex.math.toBigInteger
import java.math.BigInteger

data class ValueExprex(val value: BigInteger) : Exprex {
    override fun invoke(vararg input: BigInteger): BigInteger = value
}

fun BigInteger.toValueExprex(): ValueExprex = ValueExprex(this)

fun Byte.toValueExprex(): ValueExprex = ValueExprex(this.toBigInteger())
fun Short.toValueExprex(): ValueExprex = ValueExprex(this.toBigInteger())
fun Int.toValueExprex(): ValueExprex = ValueExprex(this.toBigInteger())
fun Long.toValueExprex(): ValueExprex = ValueExprex(this.toBigInteger())
