package com.s21g.rubyist

import scala.tools.nsc.io.Path
import scala.io.Source
import java.io._

object Pathname {
  implicit def pathnameToPath(x: Pathname): Path = x.realFile
  implicit def pathToPathname(x: Path): Pathname = new Pathname(x.path)

  def apply(path:String) = new Pathname(path)
}

class Pathname(file: String) {
  val path = Path(file)
  def realFile = path.path

  def readlines = {
    val in = Source.fromPath(realFile)
    try { in.getLines().toList }
    finally { in.close }
  }
  def read: String = readlines.mkString

  def write(buffer:String): Unit = {
    val out = new FileWriter(realFile)
    try{ out.write(buffer) }
    finally{ out.close }
  }

  // Ruby#extname contains "." but Java#extension doesn't
  def extname  = if (path.name.contains(".")) "."+path.extension else ""

  def mkpath   = path.createDirectory()
  def mkparent = path.parent.createDirectory()
}

