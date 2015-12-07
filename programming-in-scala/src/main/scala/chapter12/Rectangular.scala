package chapter12

/**
 * Created by kjs8469 on 15. 5. 5..
 */
class Point(val x: Int, val y: Int)
trait Rectangular {
  def topLeft: Point
  def bottomRight: Point

  def left = topLeft.x
  def right = bottomRight.x
  def width = right - left
}
