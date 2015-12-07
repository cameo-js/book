package chapter8

/**
 * Created by kjs8469 on 15. 4. 5..
 */
object app extends App{
  printTime()
  printTime(Console.err)

  printTime2()
  printTime2(divisor = 1000)

  def printTime(out: java.io.PrintStream = Console.out) =
    out.println("time = "+ System.currentTimeMillis())

  def printTime2(out: java.io.PrintStream = Console.out,
                  divisor: Int = 1) =
    out.println("time = "+ System.currentTimeMillis()/divisor)
}
