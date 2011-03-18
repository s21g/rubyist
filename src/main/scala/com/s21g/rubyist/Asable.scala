package com.s21g.rubyist

trait Asable {
  class Asable(a: => Any) { 
    def as[B] = a.asInstanceOf[B]
  }

  implicit def anyToAsable(a: => Any) = new Asable(a)
}

object As extends Asable
