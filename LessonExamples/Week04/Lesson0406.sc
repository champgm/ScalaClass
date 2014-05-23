import patterns._
object Lesson0406 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  println(Sum(Number(5), Number(10)).show)        //> 5 + 10
  println(Sum(Prod(Number(2), Var("x")), Var("y")).show)
                                                  //> (2 * x + y)
  println(Prod(Sum(Number(2), Var("X")), Var("Y")).show)
                                                  //> (2 + X) * Y

  //this does not work
  // println(Prod(Sum(Number(2),Var("X")),Var("Y")).eval)

}