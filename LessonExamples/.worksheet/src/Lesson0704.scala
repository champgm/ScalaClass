object Lesson0704 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(63); 
  println("Welcome to the Scala worksheet");$skip(53); 

  def from(n: Int): Stream[Int] = n #:: from(n + 1);System.out.println("""from: (n: Int)Stream[Int]""");$skip(32); 

  val naturalNumbers = from(0);System.out.println("""naturalNumbers  : Stream[Int] = """ + $show(naturalNumbers ));$skip(49); 

  val multiplesOf4 = naturalNumbers map (_ * 4);System.out.println("""multiplesOf4  : scala.collection.immutable.Stream[Int] = """ + $show(multiplesOf4 ));$skip(98); 

  def sieve(s: Stream[Int]): Stream[Int] =
    s.head #:: sieve(s.tail filter (_ % s.head != 0));System.out.println("""sieve: (s: Stream[Int])Stream[Int]""");$skip(33); 
  val allPrimes = sieve(from(2));System.out.println("""allPrimes  : Stream[Int] = """ + $show(allPrimes ));$skip(59); 
//print the 1000th prime number
  println(allPrimes(1000))}


}
