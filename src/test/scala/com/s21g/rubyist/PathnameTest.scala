import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers

import java.io.File

import com.s21g.rubyist.Pathname

class PathnameTest extends Spec with ShouldMatchers {
  // TODO: delete files recursively
  def cleanDir(path:String): Unit = {
    val dir = new File(path)
    if (dir.exists) dir.delete()
    dir.mkdirs
  }

  val langs = Pathname("src/test/resources/Pathname/langs.txt")

  describe("Pathname") {
    // ----------------------------------------------------------------------
    // Accessors
    describe("should act as Path") {
      langs.name should equal("langs.txt")
      langs.path should equal("src/test/resources/Pathname/langs.txt")
    }

    describe("should provide extname") {
      Pathname("foo.log").extname should equal(".log")
      Pathname("foo").extname should equal("")
    }

    // ----------------------------------------------------------------------
    // Actions
    describe("should write and read files") {
      cleanDir("tmp")
      val path = Pathname("tmp/foo.txt")
      path.write("rubyist")
      path.read should equal("rubyist")
    }

    describe("should read lines") {
      langs.readlines should equal(List("Ruby","Scala"))
    }

    describe("should invoke methods of Path") {
      cleanDir("tmp")
      Pathname("tmp").exists should be(true)
      Pathname("tmp/foo").exists should be(false)
    }

    describe("should make path") {
      cleanDir("tmp")
      val path = Pathname("tmp/foo/bar")
      path.exists should be(false)
      path.isDirectory should be(false)

      path.mkpath
      path.exists should be(true)
      path.isDirectory should be(true)
    }

    describe("should concat pathname") {
      val a = Pathname("a")
      val b = Pathname("b")
      val c = a + b

      c.getClass should equal(a.getClass)
      c.path should equal("a/b")
    }

    describe("should concat path string") {
      val a = Pathname("a")
      val c = a + "b"

      c.getClass should equal(a.getClass)
      c.path should equal("a/b")
    }
  }
}
