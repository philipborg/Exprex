package com.philipborg.exprex

import java.math.BigInteger

interface Exprex {
    operator fun invoke(vararg input: BigInteger): BigInteger
}