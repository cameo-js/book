package chapter21

/**
 * Created by kjs8469 on 2015. 12. 11..
 */
object app extends App {
  def maxListUpBound[T <: Ordered[T]](elements: List[T]): T =
    elements match {
    case List() =>
      throw new IllegalArgumentException("empty list!")
    case List(x) => x
    case x :: rest =>
      val maxRest = maxListUpBound(rest)
      if ( x > maxRest) x
      else maxRest
  }

  def maxListImpParm[T](elements: List[T])
                       (implicit orderer: T => Ordered[T]): T =
    elements match {
      case List() =>
        throw new IllegalArgumentException("empty list!")
      case List(x) => x
      case x :: rest =>
        val maxRest = maxListImpParm(rest)
        if ( x > maxRest) x
        else maxRest
  }

  def maxList[T <% Ordered[T]](elements: List[T]): T =
    elements match {
      case List() =>
        throw new IllegalArgumentException("empty list!")
      case List(x) => x
      case x :: rest =>
        val maxRest = maxList(rest)
        if ( x > maxRest) x
        else maxRest
    }

  println(maxListImpParm(List(1,2,3,5)))
  println(maxList(List(1.6,22,3.4)))
}


