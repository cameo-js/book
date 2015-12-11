package chapter21

/**
 * Created by kjs8469 on 2015. 12. 11..
 */
object Mocha extends App {
  class PreferredDrink(val preference: String)
  implicit val pref = new PreferredDrink("mocha")
  def enjoy(name: String)(implicit drink: PreferredDrink): Unit = {
    print("Welcome, " + name)
    print(". Enjoy a ")
    print(drink.preference)
    print("!")
  }
  enjoy("reader")
}
