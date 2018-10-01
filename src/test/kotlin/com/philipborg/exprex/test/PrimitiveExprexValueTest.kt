package com.philipborg.exprex.test

import com.philipborg.exprex.value.*
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.function.Executable

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PrimitiveExprexValueTest {
    @Test
    fun zeroPrimitive() {
        val values = listOf(
                ByteExprexValue(0),
                IntExprexValue(0),
                LongExprexValue(0),
                ShortExprexValue(0),
                DoubleExprexValue(0.0),
                FloatExprexValue(0f)
        ).map { v -> Executable { Assertions.assertEquals(0, v.toByte()) }}

        Assertions.assertAll(values)
    }

    @Test
    fun maxPrimitive() {
        val values = listOf(
                ByteExprexValue(Byte.MAX_VALUE),
                IntExprexValue(Int.MAX_VALUE),
                LongExprexValue(Long.MAX_VALUE),
                ShortExprexValue(Short.MAX_VALUE),
                DoubleExprexValue(Double.MAX_VALUE),
                FloatExprexValue(Float.MAX_VALUE)
        ).map { v -> v.value }.toTypedArray()

        val answer = listOf<Number>(
                Byte.MAX_VALUE,
                Int.MAX_VALUE,
                Long.MAX_VALUE,
                Short.MAX_VALUE,
                Double.MAX_VALUE,
                Float.MAX_VALUE
        ).toTypedArray()

        Assertions.assertArrayEquals(answer, values)
    }

    @Test
    fun minPrimitive() {
        val values = listOf(
                ByteExprexValue(Byte.MIN_VALUE),
                IntExprexValue(Int.MIN_VALUE),
                LongExprexValue(Long.MIN_VALUE),
                ShortExprexValue(Short.MIN_VALUE),
                DoubleExprexValue(Double.MIN_VALUE),
                FloatExprexValue(Float.MIN_VALUE)
        ).map { v -> v.value }.toTypedArray()

        val answer = listOf<Number>(
                Byte.MIN_VALUE,
                Int.MIN_VALUE,
                Long.MIN_VALUE,
                Short.MIN_VALUE,
                Double.MIN_VALUE,
                Float.MIN_VALUE
        ).toTypedArray()

        Assertions.assertArrayEquals(answer, values)
    }
}