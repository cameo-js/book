package chapter7

/**
 * Created by kjs8469 on 15. 4. 2..
 */

object matchtest extends App{
  val firstArg = if (args.nonEmpty) args(0) else ""

  val friend =
    firstArg match {
      case "salt" => "pepper"
      case "chips" => "salsa"
      case "egges" => "bacon"
      case _ => "huh?"
    }
  println(friend)
}
