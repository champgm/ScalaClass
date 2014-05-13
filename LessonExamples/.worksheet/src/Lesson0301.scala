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
object Lesson0301 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(787); 
  println("Welcome to the Scala worksheet");$skip(53); 

  val tree1 = new NonEmpty(3, new Empty, new Empty);System.out.println("""tree1  : NonEmpty = """ + $show(tree1 ));$skip(31); 
  val tree2 = tree1.include(4);System.out.println("""tree2  : IntSet = """ + $show(tree2 ))}
  //

  //

  //

  //

  //


  //
}
