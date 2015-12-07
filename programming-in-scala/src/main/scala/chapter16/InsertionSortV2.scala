package chapter16

/**
 * Created by kjs8469 on 15. 6. 16..
 */
object InsertionSortV2 extends App {
  def isort(xs: List[Int]): List[Int] = xs match {
    case List() => List()
    case x :: xs1 => insert(x, isort(xs1))
  }

  def insert(x: Int, xs: List[Int]): List[Int] = xs match {
    case List() => List(x)
    case y :: ys => if( x <= y) x :: xs
                    else y :: insert(x, ys)
  }

  val a = List(2, 11, 3, 5, 33, 1)
  println("Before:" + a)
  println("After:" + isort(a))
  
}
