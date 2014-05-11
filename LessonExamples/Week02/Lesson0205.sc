object Lesson0205 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  class Rational(x: Int, y: Int) {
    def numerator = x
    def denominator = y
    def n = x
    def d = y

    def +(that: Rational) = new Rational(n * that.d + that.n * d, d * that.d)
    def neg = new Rational(-n, d)
    def -(that: Rational) = this + (that.neg)

    override def toString = n + "/" + d
  }

  val one = new Rational(1, 3)                    //> one  : Lesson0205.Rational = 1/3
  val two = new Rational(1, 3)                    //> two  : Lesson0205.Rational = 1/3
  one + two                                       //> res0: Lesson0205.Rational = 6/9

  val x = new Rational(1, 3)                      //> x  : Lesson0205.Rational = 1/3
  val y = new Rational(5, 7)                      //> y  : Lesson0205.Rational = 5/7
  val z = new Rational(3, 2)                      //> z  : Lesson0205.Rational = 3/2

  x - y - z                                       //> res1: Lesson0205.Rational = -79/42
}