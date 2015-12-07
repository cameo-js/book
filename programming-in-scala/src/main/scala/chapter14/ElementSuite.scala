package chapter14

import org.scalatest.Suite
import chapter10.Element.elem

/**
 * Created by kjs8469 on 15. 5. 21..
 */
class ElementSuite extends Suite{
  def testUniformElement(): Unit = {
    val ele = elem('x', 2, 3)
    assert(ele.width == 2)
  }
}
