package chapter16

import org.scalatest.FunSuite

/**
 * Created by kjs8469 on 15. 6. 15..
 */
class app$Test extends FunSuite {
  test("List basic calc"){
    val fruit: List[String] = List("apples", "oranges", "pears")
    val nums: List[Int] = List(1, 2, 3, 4)
    val diag3: List[List[Int]] =
      List(
        List(1, 0, 0),
        List(0, 1, 0),
        List(0, 0, 1)
      )
    val empty: List[Nothing] = List()

    assert(empty.isEmpty == true)
    assert(fruit.isEmpty == false)
    assert(fruit.head == "apples")
    assert(fruit.tail.head == "oranges")
    assert(diag3.head == List(1, 0, 0))
  }
}
