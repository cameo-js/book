package sample
import scalaj.http._

/**
 * Created by kjs8469 on 15. 4. 17..
 */
object Main extends App{
  val response: HttpResponse[String] = Http("http://search.daum.net/search").params(Seq("q" -> "로또", "w" -> "tot")).asString
  println(response.body)
  println(response.code)
  println(response.headers)
}
