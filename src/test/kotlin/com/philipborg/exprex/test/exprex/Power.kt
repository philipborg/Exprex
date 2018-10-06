package com.philipborg.exprex.test.exprex

import com.philipborg.exprex.operators.PowerExprex
import com.philipborg.exprex.toValueExprex
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import java.math.BigInteger
import java.math.RoundingMode

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Power {

    @Test
    fun positivePositive() {
        val powerExprex = PowerExprex(3.toValueExprex(), 3.toValueExprex(), RoundingMode.UNNECESSARY)
        Assertions.assertEquals(27.toBigInteger(), powerExprex())
    }

    @Test
    fun negativeNegativeOdd() {
        val powerExprex = PowerExprex((-3).toValueExprex(), (-3).toValueExprex(), RoundingMode.UP)
        Assertions.assertEquals((-1).toBigInteger(), powerExprex())
    }

    @Test
    fun negativeNegativeEven() {
        val powerExprex = PowerExprex((-3).toValueExprex(), (-4).toValueExprex(), RoundingMode.UP)
        Assertions.assertEquals(BigInteger.ONE, powerExprex())
    }

    @Test
    fun negativePositiveOdd() {
        val powerExprex = PowerExprex((-3).toValueExprex(), 3.toValueExprex(), RoundingMode.UNNECESSARY)
        Assertions.assertEquals((-27).toBigInteger(), powerExprex())
    }

    @Test
    fun negativePositiveEven() {
        val powerExprex = PowerExprex((-3).toValueExprex(), 4.toValueExprex(), RoundingMode.UNNECESSARY)
        Assertions.assertEquals(81.toBigInteger(), powerExprex())
    }

    @Test
    fun positiveNegativeEven() {
        val powerExprex = PowerExprex(3.toValueExprex(), (-4).toValueExprex(), RoundingMode.UP)
        Assertions.assertEquals(BigInteger.ONE, powerExprex())
    }

    @Test
    fun positiveNegativeOdd() {
        val powerExprex = PowerExprex(3.toValueExprex(), (-3).toValueExprex(), RoundingMode.UP)
        Assertions.assertEquals(BigInteger.ONE, powerExprex())
    }

    @Test
    fun zeroPositive() {
        val powerExprex = PowerExprex(0.toValueExprex(), 3.toValueExprex(), RoundingMode.UNNECESSARY)
        Assertions.assertEquals(BigInteger.ZERO, powerExprex())
    }

    @Test
    fun zeroNegative() {
        val powerExprex = PowerExprex(0.toValueExprex(), (-3).toValueExprex(), RoundingMode.UNNECESSARY)
        Assertions.assertEquals(BigInteger.ZERO, powerExprex())
    }

    @Test
    fun zeroZero() {
        val powerExprex = PowerExprex(0.toValueExprex(), 0.toValueExprex(), RoundingMode.UNNECESSARY)
        Assertions.assertThrows(ArithmeticException::class.java) { powerExprex() }
    }

    @Test
    fun positiveZero() {
        val powerExprex = PowerExprex(3.toValueExprex(), 0.toValueExprex(), RoundingMode.UNNECESSARY)
        Assertions.assertEquals(BigInteger.ONE, powerExprex())
    }

    @Test
    fun negativeZero() {
        val powerExprex = PowerExprex((-3).toValueExprex(), 0.toValueExprex(), RoundingMode.UNNECESSARY)
        Assertions.assertEquals(BigInteger.ONE, powerExprex())
    }
}