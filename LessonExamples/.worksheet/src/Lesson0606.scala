object Lesson0606 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(63); 
  println("Welcome to the Scala worksheet")

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
  };$skip(713); 

  val p1 = new Poly(Map(1 -> 2.0, 3 -> 4.0, 5 -> 6.2));System.out.println("""p1  : Lesson0606.Poly = """ + $show(p1 ));$skip(45); 
  val p2 = new Poly(Map(0 -> 3.0, 3 -> 7.0));System.out.println("""p2  : Lesson0606.Poly = """ + $show(p2 ));$skip(10); val res$0 = 
  p1 + p2;System.out.println("""res0: Lesson0606.Poly = """ + $show(res$0))}

}
