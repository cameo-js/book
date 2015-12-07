package chapter9

/**
 * Created by kjs8469 on 15. 4. 9..
 */
object FileManager {
  private def filesHere = (new java.io.File("./src/main/scala/chapter7/")).listFiles

  def filesEnding(query: String) =
    filesMatching(_.endsWith(query))

  def filesContaining(query: String) =
    filesMatching(_.contains(query))

  def filesRegex(query: String) =
    filesMatching(_.matches(query))

  def filesMatching(matcher: (String) => Boolean) = {
    for (file <- filesHere; if matcher(file.getName))
      yield file
  }
}
