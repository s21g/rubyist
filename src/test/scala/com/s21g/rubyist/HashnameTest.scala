import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers

import java.io.File
import com.s21g.rubyist.{Pathname,Hashname}

class HathnameTest extends Spec with ShouldMatchers {

  // TODO: delete files recursively
  def cleanDir(path:String): Unit = {
    val dir = new File(path)
    if (dir.exists) dir.delete()
    dir.mkdirs
  }

/*
  describe("Hashname") {
    describe("should write and read files") {
      cleanDir("tmp")
      val file = "tmp/users/123.xml"
      val path = Pathname(file)
      val hash = Hashname(file)

      path.exists should be(false)
      hash.exists should be(false)

      path.write("rubyist")

      path.exists should be(false)
      hash.exists should be(true)

      hash.read should equal("rubyist")
    }
*/

  describe("Hashname") {
    describe("should hash directory") {
      // [given] file is 'data/uesrs/910.xml'
      val file = "data/uesrs/910.xml"

      // [when] digest of '910' is 'e205ee2a5de471a70c1fd1b46033a75f'
      val hash = Hashname(file)
//	override val digest = "e205ee2a5de471a70c1fd1b46033a75f"
      // [then] path is 'data/users/e/2/0/e205ee2a5de471a70c1fd1b46033a75f/910.xml'
//      hash.path should equal("data/users/e/2/0/e205ee2a5de471a70c1fd1b46033a75f/910.xml")
    }
  }
}
