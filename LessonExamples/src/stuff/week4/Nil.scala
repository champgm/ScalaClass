package week4

import java.util.NoSuchElementException

class Nil[T] extends List[T] {
  def head: T = throw new NoSuchElementException("No head on Nil")
  def isEmpty: Boolean = true
  def tail: List[T] = throw new NoSuchElementException("No tail on Nil")
}