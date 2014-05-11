import math.abs
object Lesson0203 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(60); 
  val tolerance = 0.0001;System.out.println("""tolerance  : Double = """ + $show(tolerance ));$skip(81); 
  def isCloseEnough(x: Double, y: Double) =
    abs((x - y) / x) / x < tolerance;System.out.println("""isCloseEnough: (x: Double, y: Double)Boolean""");$skip(267); 

  def fixedPoint(f: Double => Double)(firstGuess: Double) = {
      def iterate(guess: Double): Double = {
        println(guess)
        val next = f(guess)
        if (isCloseEnough(guess, next)) next
        else iterate(next)
      }
    iterate(firstGuess)
  };System.out.println("""fixedPoint: (f: Double => Double)(firstGuess: Double)Double""");$skip(33); val res$0 = 

  fixedPoint(x => 1 + x / 2)(1);System.out.println("""res0: Double = """ + $show(res$0));$skip(101); 

  //sqrt(x) such that y*y = x OR y=x/y

  def sqrt(x: Double) = fixedPoint(y => (y + x / y) / 2)(1);System.out.println("""sqrt: (x: Double)Double""");$skip(10); val res$1 = 
  sqrt(2);System.out.println("""res1: Double = """ + $show(res$1));$skip(68); 
  //

def averageDampen(f: Double => Double)(x:Double) = (x+f(x))/2;System.out.println("""averageDampen: (f: Double => Double)(x: Double)Double""");$skip(68); 
  def dampenedSqrt(x:Double) = fixedPoint(averageDampen(y=>x/y))(1);System.out.println("""dampenedSqrt: (x: Double)Double""");$skip(21); val res$2 = 
  
  dampenedSqrt(2);System.out.println("""res2: Double = """ + $show(res$2))}
  //

  //

  //

  //

  //

}
