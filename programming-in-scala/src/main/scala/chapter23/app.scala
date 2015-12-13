package chapter23

/**
 * Created by kjs8469 on 2015. 12. 13..
 */
object app extends App{
  case class Person(name: String, isMale: Boolean, children: Person*)

  val lara = Person("Lara", false)
  val bob = Person("Bob", true)
  val julie = Person("Julie", false, lara, bob)
  val persons = List(lara, bob, julie)

  persons filter (p => !p.isMale) flatMap (p => (p.children map ( c => (p.name, c.name))))
  persons withFilter (p => !p.isMale) flatMap (p => (p.children map ( c => (p.name, c.name))))

  for (p <- persons; if !p.isMale; c <- p.children)
    yield (p.name, c.name)

  def queens(n: Int): List[List[(Int, Int)]] = {
    def placeQueens(k: Int): List[List[(Int, Int)]] =
      if (k == 0)
        List(List())
      else
        for {
          queens <- placeQueens(k - 1)
          column <- 1 to n
          queen = (k, column)
          if isSafe(queen, queens)
        } yield queen :: queens

    placeQueens(n)
  }

  def isSafe(queen: (Int, Int), queens: List[(Int, Int)]) =
    queens forall (q => !inCheck(queen, q))

  def inCheck(q1: (Int, Int), q2: (Int, Int)) =
    q1._1 == q2._1 ||
    q1._2 == q2._2 ||
    (q1._1 - q2._1).abs == (q1._2 - q2._2).abs

  def printSolutions(tbls: List[List[(Int, Int)]]) = {
    def printSolution(tbl: List[(Int, Int)]) = {
      val len = tbl.head._1
      println("_" * (len * 2))
      for {
        dim <- tbl.reverse
        col <- 1 to len
        pipe = if ( col == 1 ) "|" else ""
        cell = if (col == dim._2) "Q|" else "_|"
        nl = if (col == len) "\n" else ""
      } print(pipe + cell + nl)
    }
    for (t <- tbls) printSolution(t)
  }

  printSolutions(queens(5))


  case class Book(title: String, authors: String*)
  val books: List[Book] =
    List(
      Book(
        "Structure and Interpretation of Computer Programs",
        "Abelson, Harold", "Sussman, Gerald J."
      ),
      Book(
        "Principles of Compiler Design",
        "Aho, Alfred", "Ullman, Jeffrey"
      ),
      Book(
        "Programming in Modula-2",
        "Wirth, Niklaus"
      ),
      Book(
        "Elements of ML Programming",
        "Ullman, Jeffrey"
      ),
      Book(
        "The Java Language Specification", "Gosling, James",
        "Joy, Bill", "Steele, Guy", "Bracha, Gillad"
      )
    )

  for (b <- books; a <- b.authors if a startsWith "Gosling") yield b.title
  for (b <- books; if (b.title indexOf "Program") >= 0) yield b.title
  for (b1 <- books; b2 <- books if b1 != b2; a1 <- b1.authors; a2 <- b2.authors if a1 == a2) yield a1
}
