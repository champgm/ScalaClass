object Lesson0107 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(63); 
  println("Welcome to the Scala worksheet");$skip(206); 

  //Tail recursive Factorial!

  def factorial(n: Int): Int = {
      def loop(accumulated: Int, n: Int): Int =
        if (n == 0) accumulated
        else loop(accumulated * n, n - 1)
    loop(1, n)
  };System.out.println("""factorial: (n: Int)Int""");$skip(16); val res$0 = 

  factorial(4);System.out.println("""res0: Int = """ + $show(res$0))}
}
