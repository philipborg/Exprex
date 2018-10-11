package com.philipborg.exprex.encoding

import com.philipborg.exprex.Exprex
import com.philipborg.exprex.ExprexId

fun ByteArray.asExprexTree(): Exprex {
    val rawValues = this.asVLQ(true).toList()
    var index = 0
    val activeNode: Exprex? = null
    while (index < rawValues.size) {
        when (ExprexId.values().single { it.id == rawValues[index].intValueExact() }) {
            ExprexId.VALUE -> TODO()
            ExprexId.VARIABLE -> TODO()
            ExprexId.ADDITION -> TODO()
            ExprexId.SUBTRACTION -> TODO()
            ExprexId.MULTIPLICATION -> TODO()
            ExprexId.DIVISION -> TODO()
            ExprexId.MODULUS -> TODO()
            ExprexId.EXPONENTIAL -> TODO()
            ExprexId.ROOT -> TODO()
            ExprexId.NEGATE -> TODO()
            ExprexId.POSITIVE -> TODO()
            ExprexId.NEGATIVE -> TODO()
        }
    }
    TODO()
}