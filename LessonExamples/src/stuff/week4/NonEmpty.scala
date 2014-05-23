package week4

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