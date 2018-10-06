package com.philipborg.exprex

abstract class ParentOfOne(val child: Exprex) : Exprex {

}

abstract class ParentOfTwo(val childOne: Exprex, val childTwo: Exprex) : Exprex {

}