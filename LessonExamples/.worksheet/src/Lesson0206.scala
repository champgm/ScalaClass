object Lesson0206 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(63); 
  println("Welcome to the Scala worksheet")
  class Rational(x: Int, y: Int) {
    def this(x: Int) = this(x, 1)

    require(y > 0, "Denominator must be greather than 0.")
    private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
    private val gDenom = gcd(x, y)

    def numerator = x
    def denominator = y

    val n = numerator
    val d = denominator

    def +(that: Rational) = new Rational(n * that.d + that.n * d, d * that.d)
    def unary_- = new Rational(-n, d)
    def -(that: Rational) = this + -that

    def <(that: Rational) = n * that.d < that.n * d

    def max(that: Rational) = if (that < this) this else that

    override def toString = {
      n / gDenom + "/" + d / gDenom
    }
  };$skip(714); 
  val x = new Rational(1, 3);System.out.println("""x  : Lesson0206.Rational = """ + $show(x ));$skip(29); 
  val y = new Rational(5, 7);System.out.println("""y  : Lesson0206.Rational = """ + $show(y ));$skip(29); 
  val z = new Rational(3, 2);System.out.println("""z  : Lesson0206.Rational = """ + $show(z ));$skip(9); val res$0 = 

  y + y;System.out.println("""res0: Lesson0206.Rational = """ + $show(res$0));$skip(9); val res$1 = 

  x < y;System.out.println("""res1: Boolean = """ + $show(res$1));$skip(12); val res$2 = 

  x.max(y);System.out.println("""res2: Lesson0206.Rational = """ + $show(res$2));$skip(83); 

  // val strange = new Rational(1, 0)
  // strange + strange

  val w = x - y - z;System.out.println("""w  : Lesson0206.Rational = """ + $show(w ));$skip(8); val res$3 = 
  y + y;System.out.println("""res3: Lesson0206.Rational = """ + $show(res$3))}
}
