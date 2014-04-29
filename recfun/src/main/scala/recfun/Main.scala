package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /** Exercise 1
    */
  def pascal(c: Int, r: Int): Int = {
    if (r == 0 || c == 0 || c == r) 1
    else pascal(c, r - 1) + pascal(c - 1, r - 1)
  }
  /** Exercise 2
    */
  def balance(chars: List[Char]): Boolean = {
      def op(char: Char): Boolean = char == '('
      def cl(char: Char): Boolean = char == ')'

      def innerBalance(chars: List[Char], openCount: Int): Boolean = {
        chars match {
          case Nil => openCount == 0
          case head :: tail if (openCount >= 0) => {
            head match {
              case head if op(head) => innerBalance(chars.tail, openCount + 1)
              case head if cl(head) => innerBalance(chars.tail, openCount - 1)
              case _ => innerBalance(chars.tail, openCount)
            }
          }
          case _ => false
        }
      }
    innerBalance(chars, 0)
  }
  /** Exercise 3
    */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money < 0) 0
    else if (money == 0) 1
    else
      coins match {
        case Nil => 0
        case head :: tail => countChange(money, tail) + countChange(money - head, coins)
      }
  }
}
