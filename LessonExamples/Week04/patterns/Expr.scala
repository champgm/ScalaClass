package patterns

case class Number(n: Int) extends Expr
case class Var(v: String) extends Expr
case class Sum(r: Expr, l: Expr) extends Expr
case class Prod(r: Expr, l: Expr) extends Expr

trait Expr {
  def eval: Int = this match {
    case Number(n) => n
    case Sum(e1, e2) => e1.eval + e2.eval
    case Prod(e1, e2) => e1.eval * e2.eval
  }
  def show: String = this match {
    case Number(n) => n.toString
    case Sum(e1, e2) => {
      (e1, e2) match {
        case (Number(e1n), Number(e2n)) => e1.show + " + " + e2.show
        case _ => "(" + e1.show + " + " + e2.show + ")"
      }
    }
    case Prod(e1, e2) => e1.show + " * " + e2.show
    case Var(v) => v
  }
}

