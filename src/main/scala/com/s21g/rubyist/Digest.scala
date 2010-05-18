package com.s21g.rubyist

import java.security.MessageDigest

object Digest {
  object MD5 {
    // code is derived from
    // http://code-redefined.blogspot.com/2009/05/md5-sum-in-scala.html
    def hexdigest(str:String): String = {
      val md5 = MessageDigest.getInstance("MD5")
      md5.reset()
      md5.update(str.getBytes)
      return md5.digest().map(0xFF & _).map { "%02x".format(_) }.foldLeft(""){_ + _}
    }
  }
}
