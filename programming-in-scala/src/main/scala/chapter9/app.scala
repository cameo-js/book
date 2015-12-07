package chapter9

import java.io.{File, PrintWriter}

/**
 * Created by kjs8469 on 15. 4. 5..
 */
object app extends App{
  for(file <- FileManager.filesEnding("app.scala"))
    println(file)

  for(file <- FileManager.filesContaining("match"))
    println(file)

  for(file <- FileManager.filesRegex("^mul"))
    println(file)

  def containsNeg(nums: List[Int]) = nums.exists(_ < 0)

  println(containsNeg(Nil))
  println(containsNeg(List(0, -1, -2)))

  def withPrintWriter(file: File)(op: PrintWriter => Unit): Unit = {
    val writer = new PrintWriter(file)
    try {
      op(writer)
    } finally {
      writer.close()
    }
  }
  val file = new File("./src/main/scala/chapter9/date.txt")
  withPrintWriter(file){
    writer => writer.println(new java.util.Date)
  }

  val assertionEnabled = true
  def myAssert(predicate: () => Boolean) =
    if (assertionEnabled && !predicate())
        throw new AssertionError

  myAssert(() => 5 > 3)

  def byNameAssert(predicate: => Boolean) =
    if (assertionEnabled && !predicate)
      throw new AssertionError

  byNameAssert(5 > 3)
}
