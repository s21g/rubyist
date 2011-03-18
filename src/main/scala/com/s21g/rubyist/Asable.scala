package com.s21g.rubyist

object As {
  class Asable[A](a: => A) { 
    def as[B] = a.asInstanceOf[B]
  }

  implicit def anyToAsable[A](a: => A) = new Asable(a)
}
