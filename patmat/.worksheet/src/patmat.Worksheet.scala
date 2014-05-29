package patmat

object Worksheet {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(78); 
  println("Welcome to the Scala worksheet");$skip(361); 

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
  };System.out.println("""sort: (xs: List[Int])List[Int]""");$skip(74); 

  println(sort(List(4, 3, 3, 992, 123, 4, 6, 8, 9, 33, 44, 99, 11, 22)));$skip(280); 

  def sort2(xs: List[(Char, Int)]): List[(Char, Int)] = {
    if (xs.length <= 1) xs
    else {
      val pivot = xs(xs.length / 2)._2
      sort2(xs.filter(pair => pair._2 < pivot)) ::: xs.filter(pair => pair._2 == pivot) ::: sort2(xs.filter(pair => pair._2 > pivot))
    }
  };System.out.println("""sort2: (xs: List[(Char, Int)])List[(Char, Int)]""");$skip(86); 

  println(sort2(List(('a', 5), ('b', 1), ('c', 50), ('d', 7), ('r', 3), ('t', 90))))}

}
