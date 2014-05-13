abstract class IntSet {
  def include(x: Int): IntSet
  def contains(x: Int): Boolean
}
class Empty extends IntSet {
  def contains(x: Int): Boolean = false
  def include(x: Int): IntSet = new NonEmpty(x, new Empty, new Empty)
  override def toString = "."
}
class NonEmpty(element: Int, left: IntSet, right: IntSet) extends IntSet {
  def contains(x: Int): Boolean = {
    if (x < element) left.contains(x)
    else if (x > element) right.contains(x)
    else true
  }
  def include(x: Int): IntSet = {
    if (x < element) new NonEmpty(element, left.include(x), right)
    else if (x > element) new NonEmpty(element, left, right.include(x))
    else this
  }
  override def toString = "{" + left + element + right + "}"
}
object Lesson0301 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  val tree1 = new NonEmpty(3, new Empty, new Empty)
                                                  //> tree1  : NonEmpty = {.3.}
  val tree2 = tree1.include(4)                    //> tree2  : IntSet = {.3{.4.}}
  //

  //

  //

  //

  //


  //
}