package com.s21g.rubyist

import scala.tools.nsc.io.Path
import scala.io.Source
import java.io._

object Pathname {
  implicit def pathnameToPath(x: Pathname): Path = x._path
  implicit def pathToPathname(x: Path): Pathname = new Pathname(x.path)

  def apply(path:String) = new Pathname(path)
}

class Pathname(path:String) {
  private val _path = Path(path)

  def read(): String = {
    val in = Source.fromPath(path)
    try{ in.mkString }
    finally{ in.close }
  }

  def write(buffer:String): Unit = {
    val out = new FileWriter(path)
    try{ out.write(buffer) }
    finally{ out.close }
  }

  def mkpath = new java.io.File(_path.parent.path).mkdirs
}
