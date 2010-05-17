import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers

class Rescueable extends Spec with ShouldMatchers {
  describe("rescue") {
    import com.s21g.rubyist.Rescue._

    describe("(with exceptions)") {
      describe("should rescue exceptions") {
	val num = "1234x1234".toLong rescue 0
	num should equal(0)
      }
    }

    describe("(without exceptions)") {
      describe("should affect nothing") {
	val num = "12341234".toLong rescue 0
	num should equal(12341234)
      }

      describe("should not evalute rescued value") {
	class Foo(var value:Int) { def succ { value += 1} }
	var foo = new Foo(0)
	foo.value should equal(0)
	val num = "12341234".toLong rescue foo.succ
	foo.value should equal(0)
      }
    }

    describe("should respect variables") {
      val rescue = 0
    }

    describe("should respect functions") {
      def rescue = "method"
      rescue should equal("method")
    }

    describe("should respect methods") {
      class Foo { def rescue(in:String) = "method" }
      val str = (new Foo) rescue "rescued"
      str should equal("method")
    }
  }
}
