package com.philipborg.exprex

import java.io.Serializable
import java.math.BigInteger

interface Exprex : Serializable {
    operator fun invoke(vararg input: BigInteger): BigInteger
}