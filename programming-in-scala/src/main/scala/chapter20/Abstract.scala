package chapter20

/**
 * Created by kjs8469 on 15. 9. 6..
 */
trait Abstract {
  type T
  def transform(x: T): T
  val initial: T
  var current: T
}
class Concrete extends Abstract {
  type T = String
  def transform(x: String) = x + x
  val initial = "hi"
  var current = initial
}
