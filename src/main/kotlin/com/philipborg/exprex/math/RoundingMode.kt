package com.philipborg.exprex.math

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

fun java.math.RoundingMode.asExprexRoundingMode(): RoundingMode = when (this) {
    java.math.RoundingMode.UP -> RoundingMode.UP
    java.math.RoundingMode.DOWN -> RoundingMode.DOWN
    java.math.RoundingMode.CEILING -> RoundingMode.CEILING
    java.math.RoundingMode.FLOOR -> RoundingMode.FLOOR
    java.math.RoundingMode.HALF_UP -> RoundingMode.HALF_UP
    java.math.RoundingMode.HALF_DOWN -> RoundingMode.HALF_DOWN
    java.math.RoundingMode.HALF_EVEN -> RoundingMode.HALF_EVEN
    java.math.RoundingMode.UNNECESSARY -> RoundingMode.UNNECESSARY
}

fun RoundingMode.asJavaRoundingMode(): java.math.RoundingMode = when (this) {
    RoundingMode.UNNECESSARY -> java.math.RoundingMode.UNNECESSARY
    RoundingMode.UP -> java.math.RoundingMode.UP
    RoundingMode.DOWN -> java.math.RoundingMode.DOWN
    RoundingMode.CEILING -> java.math.RoundingMode.CEILING
    RoundingMode.FLOOR -> java.math.RoundingMode.FLOOR
    RoundingMode.HALF_UP -> java.math.RoundingMode.HALF_UP
    RoundingMode.HALF_DOWN -> java.math.RoundingMode.HALF_DOWN
    RoundingMode.HALF_EVEN -> java.math.RoundingMode.HALF_EVEN
    RoundingMode.HALF_ODD -> throw UnmatchedRoundingMode(RoundingMode.HALF_ODD)
}

class UnmatchedRoundingMode(roundingMode: RoundingMode) : IllegalArgumentException("${roundingMode.name} was unmatched by Java RoundingMode")