package chapter17

import scala.collection.immutable.TreeSet
import scala.collection.immutable.TreeMap
import scala.collection.mutable.{ArrayBuffer, ListBuffer}
import scala.collection.mutable

/**
 * Created by kjs8469 on 15. 7. 15..
 */
object app17 extends App{
  println("시퀀스")
  val colors = List("red","blue","green")

  val fiveInts = new Array[Int](5)
  val fiveToOne = Array(5,4,3,2,1)

  val buf = new ListBuffer[Int]
  buf += 1
  buf += 2
  3 +=: buf
  println(buf)
  println(buf.toList)

  val aBuf = new ArrayBuffer[Int]()
  aBuf += 12
  aBuf += 15
  println(aBuf)

  def hasUpperCase(s: String) = s.exists(_.isUpper)
  println(hasUpperCase("Robert Frost"))
  println(hasUpperCase("e e cummings"))


  println("집합과 맵")
  val mutaSet = mutable.Set(1, 2, 3)

  val text = "See Spot run. Run, Spot. Run!"
  val wordsArray = text.split("[ !,.]+")
  val words = mutable.Set.empty[String]
  for (word <- wordsArray)
    words += word.toLowerCase
  println(wordsArray)

  def countWords(text: String) = {
    val counts = mutable.Map.empty[String,Int]
    for (rawWord <- text.split("[ ,!.]+")) {
      val word = rawWord.toLowerCase
      val oldCount =
        if (counts.contains(word))
          counts(word)
        else
          0
      counts += (word -> (oldCount + 1))
    }
    counts
  }
  println(countWords("See Spot run. Run, Spot. Run!"))


  val ts = TreeSet(9,3,1,8,0,2,7,4,6,5)
  println(ts)
  var tm = TreeMap(3->'x', 1->'x', 4->'x')
  tm += (2->'x')


  println(tm)

  val colors2 = List("blue","yellow","red","green")
  val treeSet = TreeSet[String]() ++ colors2


  val mutaSet2 = mutable.Set.empty ++= treeSet

  println(mutaSet)

}
