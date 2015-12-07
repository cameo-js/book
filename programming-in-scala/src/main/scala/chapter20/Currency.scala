package chapter20

/**
 * Created by kjs8469 on 15. 9. 16..
 */

abstract class CurrencyZone {
  type Currency <: AbstractCurrency
  def make(x: Long): Currency
  val CurrencyUnit: Currency

  abstract class AbstractCurrency {
    val amount: Long
    def designation: String
    override def toString = ((amount.toDouble / CurrencyUnit.amount.toDouble).formatted("%." + decimals(CurrencyUnit.amount) + "f") + " " + designation)
    private def decimals(n:Long): Int =
      if ( n < 10 ) 0 else 1 + decimals(n / 10)
    def + (that: Currency): Currency =
      make(this.amount + that.amount)
    def * (x: Double): Currency =
      make((this.amount * x).toLong)
  }
}
object US extends CurrencyZone {
  abstract class Dollar extends AbstractCurrency {
    def designation = "USD"
  }
  type Currency = Dollar
  def make(cents: Long) = new Dollar{
    val amount = cents
  }
  val Cent = make(1)
  val Dollar = make(100)
  val CurrencyUnit = Dollar
}