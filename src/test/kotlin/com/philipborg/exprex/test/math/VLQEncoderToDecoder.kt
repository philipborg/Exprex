package com.philipborg.exprex.test.math

import com.philipborg.exprex.math.asSingleVLQ
import com.philipborg.exprex.math.asVLQ
import com.philipborg.exprex.math.toVLQ
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class VLQEncoderToDecoder {
    @Test
    fun bigRange() {
        for (i in -10000..10000) {
            val bi = i.toBigInteger()
            Assertions.assertEquals(
                    bi,
                    when {
                        i > 0 && i % 2 == 1 -> bi.toVLQ(false).asSingleVLQ(false)
                        else -> bi.toVLQ(true).asSingleVLQ(true)
                    }
            )
        }
    }

    @Test
    fun serialVLQs() {
        val data = (-500..500).map { it.toBigInteger() }.toTypedArray()
        Assertions.assertArrayEquals(
                data,
                data.toVLQ(true).asVLQ(true).toList().toTypedArray()
        )
    }
}