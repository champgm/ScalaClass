object Lesson0106 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(63); 
  println("Welcome to the Scala worksheet")

  object oldSqrtStuff {
    def abs(x: Double) = if (x < 0) -x else x
    //Square Root stuff

    def sqrtIterator(guess: Double, x: Double): Double = {
      if (isGood(guess, x)) guess
      else sqrtIterator(improve(guess, x), x)
    }

    def isGood(guess: Double, x: Double): Boolean = {
      val compare = abs(guess * guess - x) / x
      val isgood = compare < 0.001
      isgood
    }

    def improve(guess: Double, x: Double): Double = {
      val improved = (guess + x / guess) / 2
      improved
    }

    def sqrt(x: Double): Double = {
      val sqrt = sqrtIterator(1.0, x)
      sqrt
    }
  }

  //we need to clean this up!
  object newSqrtStuff {
    def abs(x: Double) = if (x < 0) -x else x
    def sqrt(x: Double): Double = {

        //Square Root stuff

        def sqrtIterator(guess: Double): Double = {
          if (isGood(guess)) guess
          else sqrtIterator(improve(guess))
        }

        def isGood(guess: Double): Boolean = {
          val compare = abs(guess * guess - x) / x
          val isgood = compare < 0.001
          isgood
        }

        def improve(guess: Double): Double = {
          val improved = (guess + x / guess) / 2
          improved
        }

      val sqrt = sqrtIterator(1.0)
      sqrt
    }

  };$skip(1294); val res$0 = 
  newSqrtStuff.sqrt(2);System.out.println("""res0: Double = """ + $show(res$0));$skip(23); val res$1 = 
  newSqrtStuff.sqrt(4);System.out.println("""res1: Double = """ + $show(res$1));$skip(24); val res$2 = 
  newSqrtStuff.sqrt(90);System.out.println("""res2: Double = """ + $show(res$2));$skip(26); val res$3 = 
  newSqrtStuff.sqrt(.001);System.out.println("""res3: Double = """ + $show(res$3))}
}
