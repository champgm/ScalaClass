package week4

class Empty extends IntSet {
  def contains(x: Int): Boolean = false
  def include(x: Int): IntSet = new NonEmpty(x, new Empty, new Empty)
  def union(other: IntSet): IntSet = other
  override def toString = "."
}