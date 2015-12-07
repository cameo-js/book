package chapter12

/**
 * Created by kjs8469 on 15. 5. 5..
 */
class Animal
trait HasLegs

class Frog extends Animal with Philosophical with HasLegs{
  override def toString = "green"
  override def philosophize(): Unit ={
    println("It ain't easy being " + toString + "!")
  }
}
