import math.abs
object Lesson0203 {
  val tolerance = 0.0001                          //> tolerance  : Double = 1.0E-4
  def isCloseEnough(x: Double, y: Double) =
    abs((x - y) / x) / x < tolerance              //> isCloseEnough: (x: Double, y: Double)Boolean

  def fixedPoint(f: Double => Double)(firstGuess: Double) = {
      def iterate(guess: Double): Double = {
        println(guess)
        val next = f(guess)
        if (isCloseEnough(guess, next)) next
        else iterate(next)
      }
    iterate(firstGuess)
  }                                               //> fixedPoint: (f: Double => Double)(firstGuess: Double)Double

  fixedPoint(x => 1 + x / 2)(1)                   //> 1.0
                                                  //| 1.5
                                                  //| 1.75
                                                  //| 1.875
                                                  //| 1.9375
                                                  //| 1.96875
                                                  //| 1.984375
                                                  //| 1.9921875
                                                  //| 1.99609375
                                                  //| 1.998046875
                                                  //| 1.9990234375
                                                  //| 1.99951171875
                                                  //| res0: Double = 1.999755859375

  //sqrt(x) such that y*y = x OR y=x/y

  def sqrt(x: Double) = fixedPoint(y => (y + x / y) / 2)(1)
                                                  //> sqrt: (x: Double)Double
  sqrt(2)                                         //> 1.0
                                                  //| 1.5
                                                  //| 1.4166666666666665
                                                  //| 1.4142156862745097
                                                  //| res1: Double = 1.4142135623746899
  //

def averageDampen(f: Double => Double)(x:Double) = (x+f(x))/2
                                                  //> averageDampen: (f: Double => Double)(x: Double)Double
  def dampenedSqrt(x:Double) = fixedPoint(averageDampen(y=>x/y))(1)
                                                  //> dampenedSqrt: (x: Double)Double
  
  dampenedSqrt(2)                                 //> 1.0
                                                  //| 1.5
                                                  //| 1.4166666666666665
                                                  //| 1.4142156862745097
                                                  //| res2: Double = 1.4142135623746899
  //

  //

  //

  //

  //

}