package chapter15
import Math.{E,PI}

/**
 * Created by kjs8469 on 15. 5. 25..
 */
sealed abstract class Expr
case class Var(name: String) extends Expr
case class Number(num: Double) extends Expr
case class UnOp(operator: String, arg: Expr) extends Expr
case class BinOp(operator: String, left: Expr, right: Expr) extends Expr

object app15 extends App{
  val v = Var("x")
  val op = BinOp("+", Number(1), v)

  println(v)

  println( simplifyTop(BinOp("+", Number(1), Number(0)))  )

  def simplifyTop(expr: Expr): Expr = expr match {
    case UnOp("-", UnOp("-", e)) => e
    case BinOp("+", e, Number(0)) => e
    case BinOp("*", e, Number(1)) => e
    case _ => expr
  }

  println("=======")

  println("와일드카드 패턴")
  wildcard(BinOp("x",Number(1),Number(2)))
  wildcard(Number(1))

  def wildcard(x: Any) = x match {
    case BinOp(_,_,_) => println(x +" is a binary operation")
    case _ => println("It's something else")
  }

  println("상수 패턴")
  println(describe(5))
  println(describe("hello"))

  def describe(x: Any) = x match {
    case 5 => "Five"
    case true => "truth"
    case "hello" => "hi!"
    case Nil => "the empty list"
    case _ => "something else"
  }

  println("변수 패턴")
  println(variablePattern(BinOp("x",Number(1),Number(2))))
  println(variablePattern("hello"))
  println(variablePattern(Nil))
  println(variablePattern(0))

  def variablePattern(x: Any) = x match {
    case 0 => "zero"
    case somethingElse => "not zero: " + somethingElse
  }

  println("시퀀스 패턴")
  sequencePattern(List(0,1,2))
  sequencePattern(List(0,1,2,3,4))
  sequencePattern(List(0,3,4))
  sequencePattern(List(1,1,2))
  sequencePattern(List(3,1,2,3,4,5,6))
  sequencePattern(List(3))
  sequencePattern(List(3,1,2))
  sequencePattern(List())
  sequencePattern(Nil)

  def sequencePattern(x: Any) = x match {
    case List(0, _, _) => println("start with 0 found it")
    case List(3, _*) => println("start with 3found it")
    case _ => println("not found")
  }

  println("튜플 패턴")
  tuplePattern(List(0,1,2))
  tuplePattern(("a ", 3, "-tuple"))

  def tuplePattern(x: Any) = x match {
    case (a, b, c) => println("matched " + a + b + c)
    case _ => println("not matched")
  }

  println("타입지정 패턴")
  println(generalSize("abc"))
  println(generalSize(Map(1 -> 'a', 2 -> 'b')))
  println(generalSize(PI))
  println(generalSizeNotUsingMatch("abc"))
  println(generalSizeNotUsingMatch(Map(1 -> 'a', 2 -> 'b')))
  println(generalSizeNotUsingMatch(PI))

  def generalSize(x: Any) = x match {
    case s: String => s.length
    case m: Map[_, _] => m.size
    case _ => -1
  }
  def generalSizeNotUsingMatch(x: Any) = {
    if(x.isInstanceOf[String]){
      val s = x.asInstanceOf[String]
      s.length
    } else if(x.isInstanceOf[Map[_,_]]){
      val m = x.asInstanceOf[Map[_,_]]
      m.size
    } else {
      -1
    }
  }

  println("타입지정 패턴2")
  println(isIntIntMap(Map(1->2)))
  println(isIntIntMap(Map("1"->"2")))// false but true because of type erasure
  @unchecked
  def isIntIntMap(x: Any) = x match {
    case m: Map[Int,Int] => true
    case _ => false
  }

  println(isStringArray(Array("1","2")))
  println(isStringArray(Array(1,2)))
  @unchecked
  def isStringArray(x: Any) = x match {
    case m: Array[String] => "yes"
    case _ => "no"
  }

  println("변수 바인딩")
  println(isVariableBinding(UnOp("abs",UnOp("abs",Var("x")))))
  println(isVariableBinding(UnOp("abs",UnOp("abs",Number(1)))))
  println(isVariableBinding(UnOp("abs",Var("x"))))
  def isVariableBinding(x: Any) = x match {
    case UnOp("abs", e @ UnOp("abs", _)) => e
    case _ =>
  }

  println("패턴 가드")

  def simplifyAdd(e: Expr) = e match {
    case BinOp("+", x, y) if x==y => BinOp("*", x, Number(2))//case BinOp("+", x, x) 이런형태로 패턴변수가 두번이 나올수 없음
    case _ => e
  }

  println("봉인한 클래스")
  def describe(e: Expr): String = (e: @unchecked) match{//@unchecked가 없으면 컴파일에러 발생
    case Number(_) => "a number"
    case Var(_) => "a variable"
  }

  println("\n\nOption 타입")
  val capitals = Map("France" -> "Paris", "Japan" -> "Tokyo")
  def show(x: Option[String]) = x match {
    case Some(s) => s
    case None => "?"
  }
  println(show(capitals get "Japan"))
  println(show(capitals get "Japanaaa"))

  println("\n\ncase 시퀀스로 부분함수 만들기")
  val widthDefault: Option[Int] => Int = {
    case Some(x) => x
    case None => 0
  }
  println(widthDefault(Some(10)))//10
  println(widthDefault(None))//0

  val second: List[Int] => Int = {
    case x :: y :: _ => y
  }
  println(second(List(5,6,7)))//6
  //println(second(List()))//error

  val second2: PartialFunction[List[Int],Int] = {
    case x :: y :: _ => y
  }
  println(second2.isDefinedAt(List(5,6,7)))//true
  println(second2.isDefinedAt(List()))//false

  println("\n\nfor 표현식에서 패턴 사용")
  for((country, city) <- capitals)
    println("The capital of " + country + " is " + city)

  val results = List(Some("apple"), None, Some("orange"))
  for(Some(fruit) <- results) println(fruit)

}
