package chapter8

import scala.io.Source

/**
 * Created by kjs8469 on 15. 4. 5..
 */
object LongLines {
  def processFile(filename: String, width: Int): Unit = {
    def processLine(line: String): Unit ={
      if (line.length > width)
        println(filename + ": " + line.trim)
    }
    val source = Source.fromFile("src/main/scala/chapter8/"+filename)
    for (line <- source.getLines())
      processLine(line)
  }

}
