object Lesson0407 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(63); 
  println("Welcome to the Scala worksheet");$skip(161); 

  def insert(y: Int, ys: List[Int]): List[Int] = ys match {
    case List() => List(y)
    case x :: xs => if (y <= x) y :: x :: xs else x :: insert(y, xs)
  };System.out.println("""insert: (y: Int, ys: List[Int])List[Int]""");$skip(123); 

  def isort(xs: List[Int]): List[Int] = xs match {
    case List() => List()
    case y :: ys => insert(y, isort(ys))
  };System.out.println("""isort: (xs: List[Int])List[Int]""");$skip(47); 

  println(isort(List(2, 5, 6, 3,3, 1, 0, 9)))}
}
