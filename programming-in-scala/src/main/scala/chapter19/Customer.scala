package chapter19

/**
 * Created by kjs8469 on 15. 9. 4..
 * Function1의 반공변성과 공변성을 보여주는 예제
 *
 * trait Function1[-S, +T] {
 *  def apply(x: S): T
 * }
 *
 * 결과 타입은 공변
 * 파라미터 타입은 반공변
 */
class Publication(val title: String)
class Book(title: String) extends Publication(title)

object Library {
  val books: Set[Book] =
    Set(
      new Book("Programming in Scala"),
      new Book("Walden")
    )
  def printBookList(info: Book => AnyRef): Unit = {
    for (book <- books) println(info(book))
  }
}

object Customer extends App{
  def getTitle(p: Publication): String = p.title
  Library.printBookList(getTitle)
}
