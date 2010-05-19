package com.s21g.rubyist

import scala.tools.nsc.io.Path
import scala.io.Source
import java.io._

object Pathname {
  implicit def pathnameToPath(x: Pathname): Path = x.path
  implicit def pathToPathname(x: Path): Pathname = new Pathname(x.path)

  def apply(path:String) = new Pathname(path)
}

class Pathname(file: String) {
  lazy val logical = Path(file)		   // logical path
  lazy val dir     = logical.parent.toFile // maybe override
  lazy val path    = Path(dir.resolve(logical.name).path)

  def readlines = {
    val in = Source.fromPath(path.path)
    try { in.getLines().toList }
    finally { in.close }
  }
  def read: String = readlines.mkString

  def write(buffer:String): Unit = {
    val out = new FileWriter(path.path)
    try{ out.write(buffer) }
    finally{ out.close }
  }

  // Ruby#extname contains "." but Java#extension doesn't
  def extname  = if (logical.name.contains(".")) "."+logical.extension else ""

  def mkpath   = path.createDirectory()
  def mkparent = path.parent.createDirectory()
}

object Hashname {
  def apply(path:String) = new Hashname(path)
}

import com.s21g.rubyist.Digest._
class Hashname(file:String) extends Pathname(file) {
  // convert real path to hashed directory
  // [Given]
  //   file is
  //     "data/uesrs/910.xml"
  // [When]
  //   digest of "910" is
  //     "e205ee2a5de471a70c1fd1b46033a75f"
  // [Then]
  //   path should be
  //     "data/users/e/2/0/e205ee2a5de471a70c1fd1b46033a75f/910.xml"

  val digest = Digest.MD5.hexdigest(logical.stripExtension)
  val hashed = format("%s/%s/%s/%s", digest(0), digest(1), digest(2), digest)
  override lazy val dir = logical.parent.resolve(hashed).toFile
}
