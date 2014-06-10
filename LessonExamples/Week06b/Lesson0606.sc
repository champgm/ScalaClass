object Lesson0606 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  class Poly(val terms: Map[Int, Double]) {

    def adjust(term: (Int, Double)): (Int, Double) = {
      val (exponent, coefficient) = term
      terms.get(exponent) match {
        case Some(coeff) => exponent -> (coefficient + coeff)
        case None => exponent -> coefficient
      }
    }

    def +(other: Poly) = {
      val adjusted = other.terms.map(adjust)
      new Poly(terms ++ adjusted)
    }

    def oldPlus(other: Poly) = new Poly(terms ++ other.terms)
    override def toString = {
      (for {
        (exponent, coefficent) <- terms.toList.sorted.reverse
      } yield coefficent + "x^" + exponent)
        .mkString(" + ")
    }
  }

  val p1 = new Poly(Map(1 -> 2.0, 3 -> 4.0, 5 -> 6.2))
                                                  //> p1  : Lesson0606.Poly = 6.2x^5 + 4.0x^3 + 2.0x^1
  val p2 = new Poly(Map(0 -> 3.0, 3 -> 7.0))      //> p2  : Lesson0606.Poly = 7.0x^3 + 3.0x^0
  p1 + p2                                         //> res0: Lesson0606.Poly = 6.2x^5 + 11.0x^3 + 2.0x^1 + 3.0x^0

}