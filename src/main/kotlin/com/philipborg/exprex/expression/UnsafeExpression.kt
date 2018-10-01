package com.philipborg.exprex.expression

import com.philipborg.exprex.value.UnsafeExprexValue

interface UnsafeExpression<InputType : UnsafeExprexValue<*>, OutputType : UnsafeExprexValue<*>> : Expression<InputType, OutputType>