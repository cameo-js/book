package chapter14

import org.scalatest.{ShouldMatchers, FlatSpec}
import chapter10.Element.elem
/**
 * Created by kjs8469 on 15. 5. 25..
 */
class ElementSpec extends FlatSpec with ShouldMatchers{
  "A UniformElement" should "have a width equal to the passed value" in {
    val ele = elem('x',2,3)
    ele.width should be (2)
  }
  it should "throw an IAE if passed a negative width" in {
    an [IllegalArgumentException] should be thrownBy {
      elem('x', -2, 3)
    }
  }
}
