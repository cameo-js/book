package chapter16

/**
 * Created by kjs8469 on 15. 6. 15..
 */
object InsertionSortV1 extends App {
  def isort(xs: List[Int]): List[Int] =
    if (xs.isEmpty) Nil
    else insert(xs.head, isort(xs.tail))

  def insert(x: Int, xs: List[Int]): List[Int] =
    if (xs.isEmpty || x <= xs.head) x :: xs
    else xs.head :: insert(x, xs.tail)

  val a = List(2, 11, 3, 5, 33, 1)
  println("Before:" + a)
  println("After:" + isort(a))
}
