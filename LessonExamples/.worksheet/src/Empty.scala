abstract class IntSet {
  def include(x: Int): IntSet
  def contains(x: Int): Boolean
  def union(other: IntSet): IntSet
}
object Empty extends IntSet {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(192); 
  def contains(x: Int): Boolean = false;System.out.println("""contains: (x: Int)Boolean""");$skip(64); 
  def include(x: Int): IntSet = new NonEmpty(x,  Empty,  Empty);System.out.println("""include: (x: Int)IntSet""");$skip(43); 
  def union(other: IntSet): IntSet = other;System.out.println("""union: (other: IntSet)IntSet""")}
  //override def toString = "."
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
  def union(other: IntSet): IntSet = {
    ((left.union(right)).union(other)).include(element)
  }
  override def toString = "{" + left + element + right + "}"
}
object Lesson0301 {
  println("Welcome to the Scala worksheet")

  val tree1 = new NonEmpty(3,  Empty,  Empty)
  val tree2 = tree1.include(4)

  //

  //

  //

  //

  //

  //
}
