package com.philipborg.exprex.value

data class ByteExprexValue(override val value: Byte) : NumberExprexValue<Byte>(), SafeExprexValue<Byte>
data class IntExprexValue(override val value: Int) : NumberExprexValue<Int>(), SafeExprexValue<Int>
data class LongExprexValue(override val value: Long) : NumberExprexValue<Long>(), SafeExprexValue<Long>
data class ShortExprexValue(override val value: Short) : NumberExprexValue<Short>(), SafeExprexValue<Short>

data class DoubleExprexValue(override val value: Double) : NumberExprexValue<Double>(), UnsafeExprexValue<Double>
data class FloatExprexValue(override val value: Float) : NumberExprexValue<Float>(), UnsafeExprexValue<Float>