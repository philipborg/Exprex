package com.philipborg.exprex

import java.math.BigInteger

interface Exprex {
    operator fun invoke(input: Sequence<BigInteger>): BigInteger
}