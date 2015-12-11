package chapter21

/**
 * Created by kjs8469 on 2015. 12. 8..
 */
class PreferredPrompt(val preference: String)
class PreferredDrink(val preference: String)

object Greeter {
  def greet(name: String)(implicit prompt: PreferredPrompt, drink: PreferredDrink) {
    println("Welcom, " + name + ". The system is ready.")
    println("But while you work, ")
    println("why not enjoy a cup of " + drink.preference + "?")
    println(prompt.preference)
  }
}
object JoesPrefs {
  implicit val prompt = new PreferredPrompt("Yes, master>")
  implicit val drink = new PreferredDrink("tea")
}
