package chapter7

/**
 * Created by kjs8469 on 15. 4. 2..
 */

import java.net.URL
import java.net.MalformedURLException

object trytest extends App{
  def urlFor(path: String) =
    try {
      new URL(path)
    } catch {
      case e: MalformedURLException =>
        new URL("http://www.scala-lang.org")
    }

  println(urlFor("http://www.dausdfsdfm.net"))
}
