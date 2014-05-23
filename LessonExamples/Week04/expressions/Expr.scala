package expressions

trait Expr {
  def isNumber: Boolean = false
  def isSum: Boolean = false
  def isProd: Boolean = false
  def isVar: Boolean = false
  def numValue: Int = throw new Error("numValue")
  def leftOp: Expr = throw new Error("leftOp")
  def rightOp: Expr = throw new Error("rightOp")
}

class Number(n: Int) extends Expr {
  override def isNumber: Boolean = true
  override def numValue: Int = n
}

class Sum(r: Expr, l: Expr) extends Expr {
  override def isSum: Boolean = true
  override def leftOp: Expr = l
  override def rightOp: Expr = r
}

class Prod(r: Expr, l: Expr) extends Sum(r, l) {
  override def isProd = true
}

class Var(x: String) extends Expr {
  //this is a lot of work.
}