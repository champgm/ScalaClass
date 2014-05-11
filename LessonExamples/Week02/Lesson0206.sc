object Lesson0206 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
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
  }
  val x = new Rational(1, 3)                      //> x  : Lesson0206.Rational = 1/3
  val y = new Rational(5, 7)                      //> y  : Lesson0206.Rational = 5/7
  val z = new Rational(3, 2)                      //> z  : Lesson0206.Rational = 3/2

  y + y                                           //> res0: Lesson0206.Rational = 10/7

  x < y                                           //> res1: Boolean = true

  x.max(y)                                        //> res2: Lesson0206.Rational = 5/7

  // val strange = new Rational(1, 0)
  // strange + strange

  val w = x - y - z                               //> w  : Lesson0206.Rational = -79/42
  y + y                                           //> res3: Lesson0206.Rational = 10/7
}