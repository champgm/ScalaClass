import week4._
object Lesson0302 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(78); 
  println("Welcome to the Scala worksheet");$skip(49); 

  def error(msg: String) = throw new Error(msg);System.out.println("""error: (msg: String)Nothing""");$skip(194); 

  // error("bork")
  //

  def nth(n: Int, list: List[Int]): Int = {
    if (list.isEmpty) throw new IndexOutOfBoundsException
    else if (n == 0) list.head
    else nth(n - 1, list.tail)
  };System.out.println("""nth: (n: Int, list: week4.List[Int])Int""");$skip(61); 

  val list = new Cons(1, new Cons(2, new Cons(3, new Nil)));System.out.println("""list  : week4.Cons[Int] = """ + $show(list ));$skip(25); 

  println(nth(2, list));$skip(25); 
  println(nth(-1, list));$skip(25); 
  println(nth(50, list))}
  //
}
