import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers

import com.s21g.rubyist.Digest

class DigestTest extends Spec with ShouldMatchers {
  describe("Digest.MD5") {
    describe("should generate hexdigest") {
      val md5sum = Digest.MD5.hexdigest("ruby")
      md5sum should equal("58e53d1324eef6265fdb97b08ed9aadf")
    }
  }
}
