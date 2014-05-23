object Lesson0407 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  def insert(y: Int, ys: List[Int]): List[Int] = ys match {
    case List() => List(y)
    case x :: xs => if (y <= x) y :: x :: xs else x :: insert(y, xs)
  }                                               //> insert: (y: Int, ys: List[Int])List[Int]

  def isort(xs: List[Int]): List[Int] = xs match {
    case List() => List()
    case y :: ys => insert(y, isort(ys))
  }                                               //> isort: (xs: List[Int])List[Int]

  println(isort(List(2, 5, 6, 3,3, 1, 0, 9)))     //> List(0, 1, 2, 3, 3, 5, 6, 9)
}