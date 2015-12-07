package chapter16

/**
 * Created by kjs8469 on 15. 6. 15..
 */
object app16 extends App {
  val fruit = List("apples", "oranges", "pears")
  val List(a, b, c) = fruit

  println(a)
  println(b)
  println(c)

  val drink = List("soju","macjoo")
  val num = List(1,2,3)
  println(append(fruit, drink))

  def append[T](xs: List[T], ys: List[T]): List[T] =
    xs match {
      case List() => ys
      case x :: xs1 =>  x :: append(xs1, ys)
    }

  println("\n리스트 길이 구하기")
  println(fruit.length)

  println("\n리스트 양 끝에 접근하기")
  val abcde = List("a","b","c","d","e")
  println(abcde.last)
  println(abcde.init)

  println("\n리스트 뒤집기")//리스트 끝을 자주 참조하면 거꾸로 뒤집은 다음 연산하는 편이 때때로 낫다
  println(abcde.reverse)
  def rev[T] (xs: List[T]): List[T] = xs match {//reverse 구현하기
    case List() => xs
    case x :: xs1 => rev(xs1) ::: List(x)
  }

  println("\ndrop take splitAt")
  println("List(\"a\",\"b\",\"c\",\"d\",\"e\") drop 3 = " + (abcde drop 3))
  println("List(\"a\",\"b\",\"c\",\"d\",\"e\") take 3 = " + (abcde take 3))
  println("List(\"a\",\"b\",\"c\",\"d\",\"e\") splitAt 3 = " + (abcde splitAt 3))

  println("\n원소 선택 apply indices")
  println("List(\"a\",\"b\",\"c\",\"d\",\"e\") apply 3 = " + (abcde drop 3 head))

  println("\nflatten")
  println("List(List(1,2),List(3),List(),List(4,5)).flatten = " + (List(List(1,2),List(3),List(),List(4,5)).flatten))
  println(fruit.map(_.toCharArray))
  println(fruit.map(_.toCharArray).flatten)

  println("\nzip unzip")
  println("abcde.indices zip abcde = " + (abcde.indices zip abcde))
  val zipped = abcde zip List(1,2,3)
  println("zipped = " + zipped)
  println(abcde.zipWithIndex)
  println("unzip = " + zipped.unzip)

  println("\ntoString mkString")
  println(abcde.toString)
  println(abcde mkString "")
  println(abcde mkString ("1",",","nd"))

  println("\nList 클래스의 고차 메소드")
  val words = List("the", "quick", "brown", "fox")


  def reverseLeft[T] (xs: List[T]) = (List[T]() /: xs){(ys,y)=>y::ys}


  List(1,-3,4,2,6) sortWith (_ < _)
}
