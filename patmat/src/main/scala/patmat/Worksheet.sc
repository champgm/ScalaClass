package patmat

object Worksheet {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  def sort(xs: List[Int]): List[Int] = {
    if (xs.length <= 1) xs
    else {
      val pivot = xs(xs.length / 2)
      //     Array.concat(
      //      sort(xs filter (pivot >)),
      //      xs filter (pivot ==),
      //      sort(xs filter (pivot <)))
      sort(xs.filter(_ < pivot)) ::: xs.filter(_ == pivot) ::: sort(xs.filter(_ > pivot))
    }
  }                                               //> sort: (xs: List[Int])List[Int]

  println(sort(List(4, 3, 3, 992, 123, 4, 6, 8, 9, 33, 44, 99, 11, 22)))
                                                  //> List(3, 3, 4, 4, 6, 8, 9, 11, 22, 33, 44, 99, 123, 992)

  def sort2(xs: List[(Char, Int)]): List[(Char, Int)] = {
    if (xs.length <= 1) xs
    else {
      val pivot = xs(xs.length / 2)._2
      sort2(xs.filter(pair => pair._2 < pivot)) ::: xs.filter(pair => pair._2 == pivot) ::: sort2(xs.filter(pair => pair._2 > pivot))
    }
  }                                               //> sort2: (xs: List[(Char, Int)])List[(Char, Int)]

  println(sort2(List(('a', 5), ('b', 1), ('c', 50), ('d', 7), ('r', 3), ('t', 90))))
                                                  //> List((b,1), (r,3), (a,5), (d,7), (c,50), (t,90))

}