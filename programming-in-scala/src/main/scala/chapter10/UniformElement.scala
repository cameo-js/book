package chapter10

/**
 * Created by kjs8469 on 15. 4. 10..
 */
class UniformElement(
  ch: Char,
  override val width: Int,
  override val height: Int
) extends Element {
  private val line = ch.toString * width
  def contents = Array.fill(height) (line)
}
