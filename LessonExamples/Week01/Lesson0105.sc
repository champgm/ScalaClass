object Lesson0105 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  def abs(x: Double) = if (x < 0) -x else x       //> abs: (x: Double)Double

  println(abs(-1))                                //> 1.0

  //Square Root stuff

  def sqrtIterator(guess: Double, x: Double): Double = {
    if (isGood(guess, x)) guess
    else sqrtIterator(improve(guess, x), x)
  }                                               //> sqrtIterator: (guess: Double, x: Double)Double

  def isGood(guess: Double, x: Double): Boolean = {
    val compare = abs(guess * guess - x)/x
    val isgood = compare < 0.001
    isgood
  }                                               //> isGood: (guess: Double, x: Double)Boolean

  def improve(guess: Double, x: Double): Double = {
    val improved = (guess + x / guess) / 2
    improved
  }                                               //> improve: (guess: Double, x: Double)Double

  def sqrt(x: Double): Double = {
    val sqrt = sqrtIterator(1.0, x)
    sqrt
  }                                               //> sqrt: (x: Double)Double

  sqrt(2)                                         //> res0: Double = 1.4142156862745097
  sqrt(4)                                         //> res1: Double = 2.000609756097561
  sqrt(90)                                        //> res2: Double = 9.486857905512132
  sqrt(.001)                                      //> res3: Double = 0.03162278245070105
}