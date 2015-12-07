package chapter12

import scala.collection.mutable.ArrayBuffer

/**
 * Created by kjs8469 on 15. 5. 5..
 */
class BasicIntQueue extends IntQueue{
  private val buf = new ArrayBuffer[Int]
  def get() = buf.remove(0)
  def put(x: Int) { buf += x }
}

trait Doubling extends IntQueue{
  abstract override def put(x: Int) { super.put(2 * x) }
}
trait Incrementing extends IntQueue{
  abstract override def put(x: Int) { super.put(x + 1) }
}
trait Filtering extends IntQueue{
  abstract override def put(x: Int) {
    if(x >= 0) super.put(x)
  }
}