import week4._
object Lesson0401 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  object List {
    def apply[T](x: T, y: T): List[T] = new Cons(x, new Cons(y, new Nil))
    def apply = new Nil
    def apply[T](x: T): List[T] = new Cons(x, new Nil)
  }

}