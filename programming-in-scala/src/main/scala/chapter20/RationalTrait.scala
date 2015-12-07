package chapter20

/**
 * Created by kjs8469 on 15. 9. 7..
 */
trait RationalTrait {
  val numerArg: Int
  val denomArg: Int
  require(denomArg != 0)
  private val g = gcd(numerArg, denomArg)
  val numer = numerArg / g
  val denom = denomArg / g
  private def gcd(a: Int, b: Int): Int =
    if(b == 0) a else gcd(b, a % b)
  override def toString = numer + "/" + denom
}

object Demo {
  lazy val x = {println("initializing x"); "done"}
}

object RationalTraitTest extends App{
  /* 컴파일 에러 */
  /*
  new RationalTrait {
    val numerArg = 1
    val denomArg = 2
  }
  */

  /* 필드를 미리 초기화 하기 */
  new  {
    val numerArg = 1
    val denomArg = 2
  } with RationalTrait
}


