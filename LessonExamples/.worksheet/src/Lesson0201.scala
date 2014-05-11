object Lesson0201 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(63); 
  println("Welcome to the Scala worksheet");$skip(222); 

  //make this sum function tail recursive
  def sum(f: Int => Int)(a: Int, b: Int): Int = {
      def loop(a: Int, acc: Int): Int = {
        if (a > b) acc
        else loop(a + 1, f(a) + acc)
      }
    loop(a, 0)
  };System.out.println("""sum: (f: Int => Int)(a: Int, b: Int)Int""");$skip(26); val res$0 = 

  sum(x => x * x)( 3, 5);System.out.println("""res0: Int = """ + $show(res$0))}
}
