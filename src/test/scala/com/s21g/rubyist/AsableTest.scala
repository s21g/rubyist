import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers

class AsableTest extends Spec with ShouldMatchers {
  describe("as") {
    import com.s21g.rubyist.As._

    val a:AnyRef = Map("test" -> 12)
    val b = a.as[Map[String,Int]]
    b("test") should equal(12)
  }
}
