package com.philipborg.exprex.expression.tree

import com.philipborg.exprex.expression.Expression
import com.philipborg.exprex.value.ExprexValue

abstract class ExpressionTree<InputType : ExprexValue<*>, OutputType : ExprexValue<*>> : Expression<InputType, OutputType> {
}