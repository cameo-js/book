package chapter19

/**
 * Created by kjs8469 on 15. 8. 24..
 */
object app19 extends App{
  println(Queue(1,2,3));
}

class SlowAppendQueue[T] (elems: List[T]) {
  def head = elems.head
  def tail = new SlowAppendQueue(elems.tail)
  def enqueue(x: T) = new SlowAppendQueue(elems ::: List(x))
}
