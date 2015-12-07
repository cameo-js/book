package chapter7

/**
 * Created by kjs8469 on 15. 4. 2..
 */
object app extends App{
  val filesHere = (new java.io.File(".")).listFiles

  def fileLines(file: java.io.File) =
    scala.io.Source.fromFile(file).getLines().toList

  def grep(pattern: String) =
    for {
      file <- filesHere
      //if file.getName.endsWith(".scala")
      //line <- fileLines(file)
      //if line.trim.matches(pattern)
    } println(file)

  grep(".package.*")
}
