object Lesson0704 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  def from(n: Int): Stream[Int] = n #:: from(n + 1)
                                                  //> from: (n: Int)Stream[Int]

  val naturalNumbers = from(0)                    //> naturalNumbers  : Stream[Int] = Stream(0, ?)

  val multiplesOf4 = naturalNumbers map (_ * 4)   //> multiplesOf4  : scala.collection.immutable.Stream[Int] = Stream(0, ?)

  def sieve(s: Stream[Int]): Stream[Int] =
    s.head #:: sieve(s.tail filter (_ % s.head != 0))
                                                  //> sieve: (s: Stream[Int])Stream[Int]
  val allPrimes = sieve(from(2))                  //> allPrimes  : Stream[Int] = Stream(2, ?)
//print the 1000th prime number
  println(allPrimes(1000))                        //> 7927


}