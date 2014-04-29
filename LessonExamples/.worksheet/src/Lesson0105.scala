object Lesson0105 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(63); 
  println("Welcome to the Scala worksheet");$skip(45); 

  def abs(x: Double) = if (x < 0) -x else x;System.out.println("""abs: (x: Double)Double""");$skip(20); 

  println(abs(-1));$skip(161); 

  //Square Root stuff

  def sqrtIterator(guess: Double, x: Double): Double = {
    if (isGood(guess, x)) guess
    else sqrtIterator(improve(guess, x), x)
  };System.out.println("""sqrtIterator: (guess: Double, x: Double)Double""");$skip(144); 

  def isGood(guess: Double, x: Double): Boolean = {
    val compare = abs(guess * guess - x)/x
    val isgood = compare < 0.001
    isgood
  };System.out.println("""isGood: (guess: Double, x: Double)Boolean""");$skip(113); 

  def improve(guess: Double, x: Double): Double = {
    val improved = (guess + x / guess) / 2
    improved
  };System.out.println("""improve: (guess: Double, x: Double)Double""");$skip(84); 

  def sqrt(x: Double): Double = {
    val sqrt = sqrtIterator(1.0, x)
    sqrt
  };System.out.println("""sqrt: (x: Double)Double""");$skip(11); val res$0 = 

  sqrt(2);System.out.println("""res0: Double = """ + $show(res$0));$skip(10); val res$1 = 
  sqrt(4);System.out.println("""res1: Double = """ + $show(res$1));$skip(11); val res$2 = 
  sqrt(90);System.out.println("""res2: Double = """ + $show(res$2));$skip(13); val res$3 = 
  sqrt(.001);System.out.println("""res3: Double = """ + $show(res$3))}
}
