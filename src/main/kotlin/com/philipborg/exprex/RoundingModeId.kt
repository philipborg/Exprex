package com.philipborg.exprex

enum class RoundingModeId(val id: Int) {
    UNNECESSARY(1),
    UP(2),
    DOWN(3),
    CEILING(4),
    FLOOR(5),
    HALF_UP(6),
    HALF_DOWN(7),
    HALF_EVEN(8),
    HALF_ODD(9)
}