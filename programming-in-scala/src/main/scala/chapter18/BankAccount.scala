package chapter18

/**
 * Created by kjs8469 on 15. 7. 23..
 */
class BankAccount {
  private var bal: Int = 0
  def balance: Int = bal
  def deposit(amount: Int): Unit = {
    require(amount > 0)
    bal += amount
  }
  def withdraw(amount: Int): Boolean =
    if (amount > bal) false
    else {
      bal -= amount
      true
    }
}
class Time {
  private[this] var h = 12
  private[this] var m = 0

  def hour: Int = h
  def hour_=(x: Int) {
    require(0 <= x && x <= 24)
    h = x
  }

  def minute: Int = m
  def minute_=(x: Int) {
    require(0 <= x && x < 60)
    m = x
  }
}
class Thermometer {
  var celsius: Float = _ //영zero을 할당, 영 값은 타입에 따라 다르다.(0, false, null 등)
  def fahrenheit = celsius * 9 / 5 + 32
  def fahrenheit_= ( f : Float ) {
    celsius = (f - 32) * 5 / 9
  }
  override def toString = fahrenheit + "F/" + celsius + "C"
}