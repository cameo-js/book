package chapter12

/**
 * Created by kjs8469 on 15. 4. 18..
 */
class MyQueue extends BasicIntQueue with Doubling

object app extends App{
  val frog = new Frog
  frog.philosophize()

  val phil: Philosophical = frog
  phil.philosophize()

  val leg: HasLegs = frog
  phil.philosophize()

  val rect = new Rectangle(new Point(1,1), new Point(10,10))
  println(rect.left)
  println(rect.right)
  println(rect.width)

  println("======")

  var queue = new BasicIntQueue
  queue.put(10)
  queue.put(20)
  println(queue.get())
  println(queue.get())

  println("======")
  queue = new BasicIntQueue with Doubling
  queue.put(10)
  println(queue.get())

  println("======")
  queue = new BasicIntQueue with Incrementing with Filtering
  queue.put(-1)
  queue.put(0)
  queue.put(1)
  println(queue.get())
  println(queue.get())

  println("======")
  queue = new BasicIntQueue with Filtering with Incrementing
  queue.put(-1)
  queue.put(0)
  queue.put(1)
  println(queue.get())
  println(queue.get())
  println(queue.get())
}
