package com.s21g.rubyist

object Rescue {

  class Rescueable[A](a: => A) { 
    def rescue[B](b: => B) = try{a}catch{case _ => b}
  }

  implicit def anyToRescueable[A](a: => A) = new Rescueable(a)
}
