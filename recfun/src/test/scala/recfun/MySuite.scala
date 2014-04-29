package recfun

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class MySuite extends FunSuite {
  import Main.countChange

  test("countChange: algorithm example") {
    assert(countChange(10, List(1, 5)) === 3)
  }
}