package com.philipborg.exprex.expression

import com.philipborg.exprex.value.ExprexValue

interface Expression<InputType : ExprexValue<*>, OutputType : ExprexValue<*>> {
    fun resolve(vararg input: InputType): Sequence<OutputType>
    operator fun plus(value: ExprexValue<*>): Expression<InputType, OutputType>
    operator fun minus(value: ExprexValue<*>): Expression<InputType, OutputType>
}