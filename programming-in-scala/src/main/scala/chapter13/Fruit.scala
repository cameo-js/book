package chapter13.bobsdelights

/**
 * Created by kjs8469 on 15. 5. 7..
 */
abstract class Fruit (
  val name: String,
  val color: String
)

object Fruits {
  object Apple extends Fruit("apple","red")
  object Orange extends Fruit("orange","orange")
  object Pear extends Fruit("pear","yellowish")
  val menu = List(Apple,Orange,Pear)
}
