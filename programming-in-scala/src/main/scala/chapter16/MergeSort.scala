package chapter16

/**
 * Created by kjs8469 on 15. 6. 25..
 */
object MergeSort extends App{
  val abcde = List('a','b','c','d','e')
  val mixedInts = List(4,1,9,0,5,8,3,6,2,7)
  println(msort((x: Int, y: Int) => x < y)(List(5,7,1,3)))
  val intSort = msort((x: Int, y: Int) => x < y) _
  val reverseIntSort = msort((x: Int, y: Int) => x > y) _
  println(intSort(mixedInts))
  println(reverseIntSort(mixedInts))

  def msort[T](less: (T,T) => Boolean)(xs: List[T]): List[T] = {
    def merge(xs: List[T], ys: List[T]): List[T] =
      (xs, ys) match {
        case (Nil, _) => ys
        case (_, Nil) => xs
        case (x :: xs1, y :: ys1) =>
          if (less(x, y)) x :: merge(xs1, ys)
          else y :: merge(xs, ys1)
      }
    val n = xs.length / 2

    if (n == 0) xs
    else {
      val (ys, zs) = xs splitAt n
      merge(msort(less)(ys), msort(less)(zs))
    }
  }

  msort((x: Char, y: Char) => x > y)(abcde)
  abcde.sortWith(_ > _)
  //msort(_ > _)(abcde) //타입 추론을 할수 없음
  msort[Char](_ > _)(abcde) //타입추론 가능

  def msortSwapped[T](xs: List[T])(less: (T,T) => Boolean): List[T] = {
    def merge(xs: List[T], ys: List[T]): List[T] =
      (xs, ys) match {
        case (Nil, _) => ys
        case (_, Nil) => xs
        case (x :: xs1, y :: ys1) =>
          if (less(x, y)) x :: merge(xs1, ys)
          else y :: merge(xs, ys1)
      }
    val n = xs.length / 2

    if (n == 0) xs
    else {
      val (ys, zs) = xs splitAt n
      merge(msort(less)(ys), msort(less)(zs))
    }
  }

  msortSwapped(abcde)(_ > _)

}
