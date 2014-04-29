object Lesson0106 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

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

  }
  newSqrtStuff.sqrt(2)                            //> res0: Double = 1.4142156862745097
  newSqrtStuff.sqrt(4)                            //> res1: Double = 2.000609756097561
  newSqrtStuff.sqrt(90)                           //> res2: Double = 9.486857905512132
  newSqrtStuff.sqrt(.001)                         //> res3: Double = 0.03162278245070105
}