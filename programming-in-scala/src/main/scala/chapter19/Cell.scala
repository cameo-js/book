package chapter19

/**
 * Created by kjs8469 on 15. 8. 28..
 */
class Cell[T] (init: T) {
  private[this] var current = init
  def get = current
  def set(x: T) { current = x }
}
