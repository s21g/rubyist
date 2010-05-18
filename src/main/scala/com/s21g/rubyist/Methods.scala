package com.s21g.rubyist

object Methods {

  class Methods[A](a: => A) { 
    // write methods logic here
    def methods = List("Not","Implemnted","Yet")
  }

/* expected for "1.methods"
  List(
  , %, &, *, +
  , -, /, >, >=
  , >>, >>>, ^, asInstanceOf
  , isInstanceOf, toByte, toChar, toDouble
  , toFloat, toInt, toLong, toShort
  , toString, unary_+, unary_-, unary_~
  , |
  )
*/

  implicit def anyToMethods[A](a:A) = new Methods(a)
}
