import week4._
object Lesson0302 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  def error(msg: String) = throw new Error(msg)   //> error: (msg: String)Nothing

  // error("bork")
  //

  def nth(n: Int, list: List[Int]): Int = {
    if (list.isEmpty) throw new IndexOutOfBoundsException
    else if (n == 0) list.head
    else nth(n - 1, list.tail)
  }                                               //> nth: (n: Int, list: week4.List[Int])Int

  val list = new Cons(1, new Cons(2, new Cons(3, new Nil)))
                                                  //> list  : week4.Cons[Int] = week4.Cons@4b0ab323

  println(nth(2, list))                           //> 3
  println(nth(-1, list))                          //> java.lang.IndexOutOfBoundsException
                                                  //| 	at Lesson0302$$anonfun$main$1.nth$1(Lesson0302.scala:11)
                                                  //| 	at Lesson0302$$anonfun$main$1.apply$mcV$sp(Lesson0302.scala:19)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$$anonfun$$exe
                                                  //| cute$1.apply$mcV$sp(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:75)
                                                  //| 	at Lesson0302$.main(Lesson0302.scala:2)
                                                  //| 	at Lesson0302.main(Lesson0302.scala)
  println(nth(50, list))
  //
}