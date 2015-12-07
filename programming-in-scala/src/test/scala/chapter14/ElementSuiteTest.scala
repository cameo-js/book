package chapter14

import org.scalatest.FunSuite
import chapter10.Element.elem
/**
 * Created by kjs8469 on 15. 5. 21..
 */
class ElementSuiteTest extends FunSuite {
  test("elem result should have passed width") {
    val ele = elem('x', 2, 3)
    assert(ele.width === 2)

    assertResult(2){
      ele.width
    }

    intercept[IllegalArgumentException]{
      elem('x',-2,3)
    }
  }
}
