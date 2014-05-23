import week4._
object Lesson0401 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(78); 
  println("Welcome to the Scala worksheet")}

  object List {
    def apply[T](x: T, y: T): List[T] = new Cons(x, new Cons(y, new Nil))
    def apply = new Nil
    def apply[T](x: T): List[T] = new Cons(x, new Nil)
  }

}
