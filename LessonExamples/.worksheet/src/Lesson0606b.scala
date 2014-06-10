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
  };import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(1013); 

  val p1 = new Poly(1 -> 2.0, 3 -> 4.0, 5 -> 6.2);System.out.println("""p1  : Lesson0606b.Poly = """ + $show(p1 ));$skip(40); 
  val p2 = new Poly(0 -> 3.0, 3 -> 7.0);System.out.println("""p2  : Lesson0606b.Poly = """ + $show(p2 ));$skip(10); val res$0 = 
  p1 + p2;System.out.println("""res0: Lesson0606b.Poly = """ + $show(res$0));$skip(15); val res$1 = 

  p1.terms(7);System.out.println("""res1: Double = """ + $show(res$1))}

}
