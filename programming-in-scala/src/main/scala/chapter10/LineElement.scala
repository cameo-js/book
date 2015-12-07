package chapter10

/**
 * Created by kjs8469 on 15. 4. 10..
 */
class LineElement(s: String) extends Element {
  val contents = Array(s)
  override def width = s.length
  override def height = 1
}