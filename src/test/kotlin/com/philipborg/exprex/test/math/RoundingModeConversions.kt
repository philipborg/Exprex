package com.philipborg.exprex.test.math

import com.philipborg.exprex.math.RoundingMode
import com.philipborg.exprex.math.UnmatchedRoundingMode
import com.philipborg.exprex.math.asExprexRoundingMode
import com.philipborg.exprex.math.asJavaRoundingMode
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RoundingModeConversions {
    @Test
    fun fromExprex() {
        Assertions.assertEquals(RoundingMode.UNNECESSARY.asJavaRoundingMode(), java.math.RoundingMode.UNNECESSARY)
        Assertions.assertEquals(RoundingMode.UP.asJavaRoundingMode(), java.math.RoundingMode.UP)
        Assertions.assertEquals(RoundingMode.DOWN.asJavaRoundingMode(), java.math.RoundingMode.DOWN)
        Assertions.assertEquals(RoundingMode.CEILING.asJavaRoundingMode(), java.math.RoundingMode.CEILING)
        Assertions.assertEquals(RoundingMode.FLOOR.asJavaRoundingMode(), java.math.RoundingMode.FLOOR)
        Assertions.assertEquals(RoundingMode.HALF_UP.asJavaRoundingMode(), java.math.RoundingMode.HALF_UP)
        Assertions.assertEquals(RoundingMode.HALF_DOWN.asJavaRoundingMode(), java.math.RoundingMode.HALF_DOWN)
        Assertions.assertEquals(RoundingMode.HALF_EVEN.asJavaRoundingMode(), java.math.RoundingMode.HALF_EVEN)
        Assertions.assertThrows(UnmatchedRoundingMode::class.java) { RoundingMode.HALF_ODD.asJavaRoundingMode() }
    }

    @Test
    fun fromJava() {
        Assertions.assertEquals(java.math.RoundingMode.UNNECESSARY.asExprexRoundingMode(), RoundingMode.UNNECESSARY)
        Assertions.assertEquals(java.math.RoundingMode.UP.asExprexRoundingMode(), RoundingMode.UP)
        Assertions.assertEquals(java.math.RoundingMode.DOWN.asExprexRoundingMode(), RoundingMode.DOWN)
        Assertions.assertEquals(java.math.RoundingMode.CEILING.asExprexRoundingMode(), RoundingMode.CEILING)
        Assertions.assertEquals(java.math.RoundingMode.FLOOR.asExprexRoundingMode(), RoundingMode.FLOOR)
        Assertions.assertEquals(java.math.RoundingMode.HALF_UP.asExprexRoundingMode(), RoundingMode.HALF_UP)
        Assertions.assertEquals(java.math.RoundingMode.HALF_DOWN.asExprexRoundingMode(), RoundingMode.HALF_DOWN)
        Assertions.assertEquals(java.math.RoundingMode.HALF_EVEN.asExprexRoundingMode(), RoundingMode.HALF_EVEN)
    }
}