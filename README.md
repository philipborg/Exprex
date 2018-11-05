# Exprex
[ ![Download](https://api.bintray.com/packages/philipborg/Exprex/Exprex/images/download.svg) ](https://bintray.com/philipborg/Exprex/Exprex/_latestVersion)
[![CircleCI branch](https://img.shields.io/circleci/project/github/philipborg/Exprex/master.svg)](https://circleci.com/gh/philipborg/Exprex/tree/master)
[![GitHub](https://img.shields.io/github/license/philipborg/Exprex.svg)](https://www.apache.org/licenses/LICENSE-2.0)
![GitHub top language](https://img.shields.io/github/languages/top/philipborg/Exprex.svg)
![GitHub code size in bytes](https://img.shields.io/github/languages/code-size/philipborg/Exprex.svg)

Integer math expression library and language written in Kotlin.

## Features
* [Variable-length quantity (VLQ)](https://en.wikipedia.org/wiki/Variable-length_quantity)
  * Unsigned and signed
  * Supports [BigInteger](https://docs.oracle.com/javase/8/docs/api/java/math/BigInteger.html)
* Mathematical expression trees
  * Integer input and result for all operations
  * Incorrect or undefined rounding is forbidden
  * Serializable 
  * Nodes
    * [Addition](https://en.wikipedia.org/wiki/Addition)
    * [Division](https://en.wikipedia.org/wiki/Division_(mathematics))
    * [Modulus](https://en.wikipedia.org/wiki/Modular_arithmetic)
    * [Multiplication](https://en.wikipedia.org/wiki/Multiplication)
    * Negate, inverse sign
    * Negative, set negative sign.
    * Positive, set positive sign. A.K.A. [Absolute Value](https://en.wikipedia.org/wiki/Absolute_value).
    * [Power](https://en.wikipedia.org/wiki/Exponentiation)
    * [Subtraction](https://en.wikipedia.org/wiki/Subtraction)
* Mathematics operators extension methods
  * Supports many Integer types
    * [BigInteger](https://docs.oracle.com/javase/8/docs/api/java/math/BigInteger.html)
    * Byte/UByte
    * Short/UShort
    * Int/UInt
    * Long/ULong
  * No rounding errors
  * Division with RoundingMode
  * Exponentiation with RoundingMode
* Convert to bytes
  * Big or Little Endian
  * Short/UShort
  * Int/UInt
  * Long/ULong