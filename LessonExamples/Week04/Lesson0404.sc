import week4._
object Lesson0404 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  def f(xs: List[NonEmpty], x: Empty) = xs.prepend(x)
                                                  //> f: (xs: week4.List[week4.NonEmpty], x: week4.Empty)week4.List[week4.IntSet]
  val x = Nil                                     //> x  : week4.Nil.type = week4.Nil$@4b0ab323
  
}