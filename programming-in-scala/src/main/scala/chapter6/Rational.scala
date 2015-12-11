package chapter6

/**
 * Created by kjs8469 on 2015. 12. 8..
 */
class Rational(n: Int, d: Int) {
  require(d != 0)
  private val g = gcd(n.abs, d.abs)
  val number = n / g
  val denom = d / g
  def this(n: Int) = this(n, 1)
  def + (that: Rational): Rational =
    new Rational(
      number * that.denom + this.number * denom,
      denom * that.denom
    )
  def + (i: Int): Rational =
    new Rational(number + i * denom, denom)

  override def toString = number + "/" + denom

  private def gcd(a: Int, b: Int): Int =
   if(b == 0) a else gcd(b, a % b)
}
