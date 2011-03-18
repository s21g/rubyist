import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers

class AsableTest extends Spec with ShouldMatchers {
  describe("as") {
    describe("import") {
      import com.s21g.rubyist.As._

      val a:AnyRef = Map("test" -> 12)
      val b = a.as[Map[String,Int]]
      b("test") should equal(12)
    }

    describe("extends") {
      class Foo extends com.s21g.rubyist.Asable {
        val a:AnyRef = Map("test" -> 12)
        val b = a.as[Map[String,Int]]
        b("test") should equal(12)
      }
      new Foo
    }
  }
}
