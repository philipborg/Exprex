package com.philipborg.exprex

enum class ExprexId(val id: Int, val parameters: Int) {
    VALUE(0, 1),
    VARIABLE(1, 1),
    ADDITION(3, 2),
    SUBTRACTION(4, 2),
    MULTIPLICATION(5, 2),
    DIVISION(6, 3),
    MODULUS(7, 2),
    EXPONENTIAL(8, 3),
    ROOT(9, 3),
    NEGATE(10, 1),
    POSITIVE(11, 1),
    NEGATIVE(12, 1)
}