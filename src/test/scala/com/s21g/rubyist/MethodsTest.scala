import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers

class MethodsTest extends Spec with ShouldMatchers {
  describe("methods") {
    import com.s21g.rubyist.Methods._

    describe("should return list") {
      val intMethods = """
        %              &              *              +
        -              /              >              >=
        >>             >>>            ^              asInstanceOf
        isInstanceOf   toByte         toChar         toDouble
        toFloat        toInt          toLong         toShort
        toString       unary_+        unary_-        unary_~
        |
      """ split(" ") filterNot(_.isEmpty) toList
      val m = 1.methods
//      m should equal(intMethods)
    }

    describe("should respect variables") {
      val methods = 0
    }

    describe("should respect functions") {
      def methods = "method"
      methods should equal("method")
    }

    describe("should respect methods") {
      class Foo { def methods(in:String) = "method" }
      val str = (new Foo) methods("foo")
      str should equal("method")
    }

  }
}
