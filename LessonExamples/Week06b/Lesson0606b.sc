object Lesson0606b {

  class Poly(val inTerms: Map[Int, Double]) {

    def this(bindings: (Int, Double)*) = this(bindings.toMap)

    val terms = inTerms.withDefaultValue(0.0)

    def adjust(term: (Int, Double)): (Int, Double) = {
      val (exponent, coefficient) = term
      exponent -> (coefficient + terms(exponent))
    }

    def +(other: Poly) = {
      new Poly(other.terms.foldLeft(terms)(addTerm))
    }

    def addTerm(inTerms: Map[Int, Double], term: (Int, Double)) = {
      val terms = inTerms.withDefaultValue(0.0)
      terms + ((term._1, term._2 + terms(term._1)))
    }

    def oldPlus(other: Poly) = {
      val adjusted = other.terms.map(adjust)
      new Poly(terms ++ adjusted)
    }

    def veryOldPlus(other: Poly) = new Poly(terms ++ other.terms)
    override def toString = {
      (for {
        (exponent, coefficent) <- terms.toList.sorted.reverse
      } yield coefficent + "x^" + exponent)
        .mkString(" + ")
    }
  }

  val p1 = new Poly(1 -> 2.0, 3 -> 4.0, 5 -> 6.2) //> p1  : Lesson0606b.Poly = 6.2x^5 + 4.0x^3 + 2.0x^1
  val p2 = new Poly(0 -> 3.0, 3 -> 7.0)           //> p2  : Lesson0606b.Poly = 7.0x^3 + 3.0x^0
  p1 + p2                                         //> res0: Lesson0606b.Poly = 6.2x^5 + 11.0x^3 + 2.0x^1 + 3.0x^0

  p1.terms(7)                                     //> res1: Double = 0.0

}