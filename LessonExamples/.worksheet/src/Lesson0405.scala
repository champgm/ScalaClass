import expressions._
object Lesson0405 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(84); 
  println("Welcome to the Scala worksheet");$skip(175); 
  def eval(e: Expr): Int = {
    if (e.isNumber) e.numValue
    else if (e.isSum) eval(e.leftOp) + eval(e.rightOp)
    else throw new Error("unknown expression type" + e)
  };System.out.println("""eval: (e: expressions.Expr)Int""");$skip(55); 
  println(eval(new Sum(new Number(1), new Number(2))))}
}
