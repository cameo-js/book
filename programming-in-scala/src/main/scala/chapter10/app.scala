package chapter10
import Element._
import Spiral.spiral

/**
 * Created by kjs8469 on 15. 4. 5..
 */
object app10 extends App{
  val column1 = elem("hello") above elem("---") above elem("+++")
  val column2 = elem("***") above elem("world!")
  val column3 = elem("***")

  val graph = column1 beside column3 beside column2
  //println(graph.toString)

  println(spiral(6,0))
  println(spiral(7,0))
  println(spiral(8,0))
  println(spiral(9,0))
}
