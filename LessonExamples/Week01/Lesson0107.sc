object Lesson0107 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  //Tail recursive Factorial!

  def factorial(n: Int): Int = {
      def loop(accumulated: Int, n: Int): Int =
        if (n == 0) accumulated
        else loop(accumulated * n, n - 1)
    loop(1, n)
  }                                               //> factorial: (n: Int)Int

  factorial(4)                                    //> res0: Int = 24
}