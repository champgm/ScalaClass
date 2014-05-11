object Lesson0205 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(63); 
  println("Welcome to the Scala worksheet")

  class Rational(x: Int, y: Int) {
    def numerator = x
    def denominator = y
    def n = x
    def d = y

    def +(that: Rational) = new Rational(n * that.d + that.n * d, d * that.d)
    def neg = new Rational(-n, d)
    def -(that: Rational) = this + (that.neg)

    override def toString = n + "/" + d
  };$skip(346); 

  val one = new Rational(1, 3);System.out.println("""one  : Lesson0205.Rational = """ + $show(one ));$skip(31); 
  val two = new Rational(1, 3);System.out.println("""two  : Lesson0205.Rational = """ + $show(two ));$skip(12); val res$0 = 
  one + two;System.out.println("""res0: Lesson0205.Rational = """ + $show(res$0));$skip(30); 

  val x = new Rational(1, 3);System.out.println("""x  : Lesson0205.Rational = """ + $show(x ));$skip(29); 
  val y = new Rational(5, 7);System.out.println("""y  : Lesson0205.Rational = """ + $show(y ));$skip(29); 
  val z = new Rational(3, 2);System.out.println("""z  : Lesson0205.Rational = """ + $show(z ));$skip(13); val res$1 = 

  x - y - z;System.out.println("""res1: Lesson0205.Rational = """ + $show(res$1))}
}
