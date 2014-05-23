package week4

import java.util.NoSuchElementException

object Nil extends List[Nothing] {
  def isEmpty: Boolean = true
  def tail: List[Nothing] = throw new NoSuchElementException("No tail on Nil")
  def head: Nothing = throw new NoSuchElementException("No head on Nil")
}
