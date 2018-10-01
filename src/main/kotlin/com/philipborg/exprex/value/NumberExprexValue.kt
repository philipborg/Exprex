package com.philipborg.exprex.value

abstract class NumberExprexValue<N : Number> : ExprexValue<N>, Number() {
    abstract val value : N

    override fun toByte(): Byte = value.toByte()

    override fun toChar(): Char = value.toChar()

    override fun toDouble(): Double = value.toDouble()

    override fun toFloat(): Float = value.toFloat()

    override fun toInt(): Int = value.toInt()

    override fun toLong(): Long = value.toLong()

    override fun toShort(): Short = value.toShort()
}