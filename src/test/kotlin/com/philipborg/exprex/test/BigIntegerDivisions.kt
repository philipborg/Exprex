package com.philipborg.exprex.test

import com.philipborg.exprex.math.div
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.function.Executable
import java.math.BigInteger
import java.math.RoundingMode
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BigIntegerDivisions {
    @Test
    fun unnecessary() {
        val scenarios = resolve(RoundingMode.UNNECESSARY,
                Scenario(100, 10, 10),
                Scenario(100, -10, -10),
                Scenario(0, 100, 0)
        )
        Assertions.assertAll(scenarios)
        Assertions.assertThrows(ArithmeticException::class.java) { BigInteger.ONE.div(2, RoundingMode.UNNECESSARY) }
        Assertions.assertThrows(ArithmeticException::class.java) { BigInteger.ONE.div(0, RoundingMode.UNNECESSARY) }
    }

    @Test
    fun ceiling() {
        val scenarios = resolve(RoundingMode.CEILING,
                Scenario(100, 10, 10),
                Scenario(100, 9, 12),
                Scenario(100, -9, -11),
                Scenario(0, 100, 0),
                Scenario(1, 2, 1),
                Scenario(-1, 2, 0),
                Scenario(1, -2, 0)
        )
        Assertions.assertAll(scenarios)
    }

    @Test
    fun floor() {
        val scenarios = resolve(RoundingMode.FLOOR,
                Scenario(100, 10, 10),
                Scenario(100, 9, 11),
                Scenario(100, -9, -12),
                Scenario(0, 100, 0),
                Scenario(1, 2, 0),
                Scenario(-1, 2, -1),
                Scenario(1, -2, -1)
        )
        Assertions.assertAll(scenarios)
    }

    @Test
    fun up() {
        val scenarios = resolve(RoundingMode.UP,
                Scenario(100, 10, 10),
                Scenario(100, 9, 12),
                Scenario(100, -9, -12),
                Scenario(0, 100, 0),
                Scenario(1, 2, 1),
                Scenario(-1, 2, -1),
                Scenario(1, -2, -1)
        )
        Assertions.assertAll(scenarios)
    }

    @Test
    fun down() {
        val scenarios = resolve(RoundingMode.DOWN,
                Scenario(100, 10, 10),
                Scenario(100, 9, 11),
                Scenario(100, -9, -11),
                Scenario(0, 100, 0),
                Scenario(1, 2, 0),
                Scenario(-1, 2, 0),
                Scenario(1, -2, 0)
        )
        Assertions.assertAll(scenarios)
    }

    @Test
    fun half_down() {
        val scenarios = resolve(RoundingMode.HALF_DOWN,
                Scenario(100, 10, 10),
                Scenario(100, 9, 11),
                Scenario(100, -9, -11),
                Scenario(0, 100, 0),
                Scenario(1, 2, 0),
                Scenario(-1, 2, 0),
                Scenario(1, -2, 0),
                Scenario(5, 3, 2),
                Scenario(3, 2, 1),
                Scenario(-16, 10, -2)
        )
        Assertions.assertAll(scenarios)
    }


    private fun resolve(roundingMode: RoundingMode, vararg scenarios: Scenario): Stream<Executable> {
        return scenarios.map {
            Executable { Assertions.assertEquals(it.output.toBigInteger(), it.dividend.toBigInteger().div(it.divisor, roundingMode)) }
        }.stream()
    }

    data class Scenario(val dividend: Long, val divisor: Long, val output: Long)
}
