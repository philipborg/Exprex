package com.philipborg.exprex

import com.philipborg.exprex.math.toBigInteger
import java.math.BigInteger

data class ValueNode(val value: BigInteger) : ExpressionNode {
    override fun invoke(vararg input: BigInteger): BigInteger = value
}

fun BigInteger.toValueNode(): ValueNode = ValueNode(this)
fun Byte.toValueNode(): ValueNode = ValueNode(this.toBigInteger())
fun Short.toValueNode(): ValueNode = ValueNode(this.toBigInteger())
fun Int.toValueNode(): ValueNode = ValueNode(this.toBigInteger())
fun Long.toValueNode(): ValueNode = ValueNode(this.toBigInteger())
