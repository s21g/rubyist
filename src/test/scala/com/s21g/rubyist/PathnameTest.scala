import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers

import java.io.File

class PathnameTest extends Spec with ShouldMatchers {
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

    describe("should invoke methods of Path") {
      cleanDir("tmp")
      Pathname("tmp").exists should equal(true)
      Pathname("tmp/foo").exists should equal(false)
    }

    describe("should make path") {
      cleanDir("tmp")
      val path = Pathname("tmp/foo/bar/debug.log")
      path.parent.exists should equal(false)

      path.mkpath
      path.parent.exists should equal(true)
      path.exists should equal(false)
    }
  }
}
