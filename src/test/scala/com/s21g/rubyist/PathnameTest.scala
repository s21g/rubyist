import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers

import java.io.File

class PathnameTest extends Spec with ShouldMatchers {
  // TODO: delete files recursively
  def cleanDir(path:String): Unit = {
    val dir = new File(path)
    if (dir.exists) dir.delete()
    dir.mkdirs
  }

  describe("Pathname") {
    import com.s21g.rubyist.Pathname

    describe("should write and read files") {
      cleanDir("tmp")
      val path = Pathname("tmp/foo.txt")
      path.write("rubyist")
      path.read should equal("rubyist")
    }

    describe("should read lines") {
      val langs = Pathname("src/test/resources/Pathname/langs.txt")
      langs.readlines should equal(List("Ruby","Scala"))
    }

    describe("should invoke methods of Path") {
      cleanDir("tmp")
      Pathname("tmp").exists should be(true)
      Pathname("tmp/foo").exists should be(false)
    }

    describe("should make path") {
      cleanDir("tmp")
      val path = Pathname("tmp/foo/bar/debug.log")
      path.parent.exists should be(false)

      path.mkpath
      path.parent.exists should be(true)
      path.exists should be(false)
    }
  }
}
