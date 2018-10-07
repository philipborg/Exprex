package com.philipborg.exprex

import java.math.RoundingMode

abstract class Unary(val child: Exprex) : Exprex

abstract class UnaryRounding(val child: Exprex, val rounding: RoundingMode) : Exprex

abstract class Binary(val childOne: Exprex, val childTwo: Exprex) : Exprex

abstract class BinaryRounding(val childOne: Exprex, val childTwo: Exprex, val rounding: RoundingMode) : Exprex