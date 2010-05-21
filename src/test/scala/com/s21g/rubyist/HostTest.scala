import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers

import java.io.File

import com.s21g.rubyist._

class HostTest extends Spec with ShouldMatchers {
  describe("Host") {
    // ----------------------------------------------------------------------
    // Accessors

    // Since I don't know how to stub yet, use concrete object instead.
    val host = CurrentHost

    describe("should provide name") {
      host.name.getClass should equal("".getClass)
    }
  }
}
