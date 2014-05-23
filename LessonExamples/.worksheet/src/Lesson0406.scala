import patterns._
object Lesson0406 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(81); 
  println("Welcome to the Scala worksheet");$skip(44); 

  println(Sum(Number(5), Number(10)).show);$skip(57); 
  println(Sum(Prod(Number(2), Var("x")), Var("y")).show);$skip(57); 
  println(Prod(Sum(Number(2), Var("X")), Var("Y")).show)}

  //this does not work
  // println(Prod(Sum(Number(2),Var("X")),Var("Y")).eval)

}
