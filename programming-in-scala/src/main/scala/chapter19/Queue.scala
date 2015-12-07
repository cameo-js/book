package chapter19

/**
 * Created by kjs8469 on 15. 8. 25..
 */

/**
 * 대안1) 비공개 생성자와 팩토리 메소드
 */
/* 대안1
class Queue[T] private (
  private val leading: List[T],
  private val trailing: List[T]
){
  private def mirror =
    if (leading.isEmpty)
      new Queue(trailing.reverse, Nil)
    else
      this

  def head = mirror.leading.head

  def tail = {
    val q = mirror
    new Queue(q.leading.tail, q.trailing)
  }

  def enqueue(x: T) =
    new Queue(leading, x :: trailing)
}
object Queue {
  def apply[T] (xs: T*) = new Queue[T](xs.toList, Nil)
}
*/
/**
 * 대안2) 비공개 생성자와 팩토리 메소드
 */
trait Queue[T] {
  def head: T
  def tail: Queue[T]
  def enqueue(x: T): Queue[T]
}
object Queue {
  def apply[T](xs: T*): Queue[T] =
    new QueueImpl[T](xs.toList, Nil)
  private class QueueImpl[T](
    private val leading: List[T],
    private val trailing: List[T]
  ) extends Queue[T] {
    def mirror =
      if (leading.isEmpty)
        new QueueImpl(trailing.reverse, Nil)
      else
        this

    def head = mirror.leading.head

    def tail = {
      val q = mirror
      new QueueImpl(q.leading.tail, q.trailing)
    }

    def enqueue(x: T) =
      new QueueImpl(leading, x :: trailing)
  }
}