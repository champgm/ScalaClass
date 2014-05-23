//Peano Numbers
object Lesson0402 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(79); 
  println("Welcome to the Scala worksheet")}

  abstract class Nat {
    def isZero: Boolean
    def predecessor: Nat
    def successor = new Succ(this)
    def +(that: Nat): Nat
    def -(that: Nat): Nat
  }

  object Zero extends Nat {
    def isZero = true
    def predecessor = throw new Error("No predecessor of Zero")
    def +(that: Nat) = that
    def -(that: Nat) = {
      if (that.isZero) this
      else throw new Error("Can't subtract from Zero")
    }
  }

  class Succ(n: Nat) extends Nat {
    def isZero = false
    def predecessor = n
    def +(that: Nat) = new Succ(n + that)
    def -(that: Nat) = {
      if (that.isZero) this
      else n - that.predecessor
    }
  }

}
