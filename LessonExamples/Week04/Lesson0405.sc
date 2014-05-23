import expressions._
object Lesson0405 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  def eval(e: Expr): Int = {
    if (e.isNumber) e.numValue
    else if (e.isSum) eval(e.leftOp) + eval(e.rightOp)
    else throw new Error("unknown expression type" + e)
  }                                               //> eval: (e: expressions.Expr)Int
  println(eval(new Sum(new Number(1), new Number(2))))
                                                  //> 3
}