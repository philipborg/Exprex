package com.philipborg.exprex.expression

import com.philipborg.exprex.value.SafeExprexValue

interface SafeExpression<InputType : SafeExprexValue<*>, OutputType : SafeExprexValue<*>> : Expression<InputType, OutputType> {
    operator fun plus(value: SafeExprexValue<*>): SafeExpression<InputType, OutputType>
    operator fun minus(value: SafeExprexValue<*>): SafeExpression<InputType, OutputType>
}