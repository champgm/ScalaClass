object Lesson0705 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  val problem = new Pouring(Vector(4, 9))         //> problem  : Pouring = Pouring@6766afb3
  problem.moves                                   //> res0: scala.collection.immutable.IndexedSeq[Product with Serializable with L
                                                  //| esson0705.problem.Move] = Vector(Empty(0), Empty(1), Fill(0), Fill(1), Pour(
                                                  //| 0,1), Pour(1,0))

  //problem.pathSets.take(3).toList

  problem.solution(6)                             //> res1: Stream[Lesson0705.problem.Path] = Stream(Fill(1) Pour(1,0) Empty(0) Po
                                                  //| ur(1,0) Empty(0) Pour(1,0) Fill(1) Pour(1,0)-->Vector(4, 6), ?)

}