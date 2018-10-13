package com.philipborg.exprex

enum class RoundingMode(val id: Int) {
    UNNECESSARY(0),
    UP(1),
    DOWN(2),
    CEILING(3),
    FLOOR(4),
    HALF_UP(5),
    HALF_DOWN(6),
    HALF_EVEN(7),
    HALF_ODD(8)
}