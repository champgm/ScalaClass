object Lesson0705 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(63); 
  println("Welcome to the Scala worksheet");$skip(43); 

  val problem = new Pouring(Vector(4, 9));System.out.println("""problem  : Pouring = """ + $show(problem ));$skip(16); val res$0 = 
  problem.moves;System.out.println("""res0: scala.collection.immutable.IndexedSeq[Product with Serializable with Lesson0705.problem.Move] = """ + $show(res$0));$skip(60); val res$1 = 

  //problem.pathSets.take(3).toList

  problem.solution(6);System.out.println("""res1: Stream[Lesson0705.problem.Path] = """ + $show(res$1))}

}
