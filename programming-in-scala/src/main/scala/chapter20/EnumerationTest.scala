package chapter20

/**
 * Created by kjs8469 on 15. 9. 16..
 */
object EnumerationTest extends App{
  println(Color.Blue)
  println(Direction.East)
  for ( d <- Direction.values) println(d + " ")
  println(Direction(1))
}
object Color extends Enumeration {
  val Red, Green, Blue = Value
}
object Direction extends Enumeration {
  val South = Value("south")
  val North = Value("north")
  val West = Value("west")
  val East = Value("east")
}
