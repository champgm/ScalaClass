import scala.io.Source
object Lesson0607 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(86); 
  println("Welcome to the Scala worksheet");$skip(50); 

  val input = Source.fromFile("/linuxwords.txt");System.out.println("""input  : scala.io.BufferedSource = """ + $show(input ));$skip(88); 

  val words = input.getLines.toList.filter(word => word.forall(char => char isLetter));System.out.println("""words  : List[String] = """ + $show(words ));$skip(170); 

  val numberMap = Map(
    ('2', "ABC"),
    ('3', "DEF"),
    ('4', "GHI"),
    ('5', "JKL"),
    ('6', "MNO"),
    ('7', "PQRS"),
    ('8', "TUV"),
    ('9', "WXYZ"));System.out.println("""numberMap  : scala.collection.immutable.Map[Char,String] = """ + $show(numberMap ));$skip(197); 
  //first thing we need to do is get a map from character to digit
  val charCode: Map[Char, Char] =
    for {
      (digit, string) <- numberMap
      letter <- string
    } yield (letter, digit);System.out.println("""charCode  : Map[Char,Char] = """ + $show(charCode ));$skip(126); 
  //Map a word to the digit string it can represent
  def wordCode(word: String): String =
    word.toUpperCase.map(charCode);System.out.println("""wordCode: (word: String)String""");$skip(20); val res$0 = 

  wordCode("Java");System.out.println("""res0: String = """ + $show(res$0));$skip(124); 

  //now, the other direction
  val wordsForNum: Map[String, Seq[String]] = words.groupBy(wordCode).withDefaultValue(Seq());System.out.println("""wordsForNum  : Map[String,Seq[String]] = """ + $show(wordsForNum ));$skip(319); 

  //return all way sto encode a number as a list of words
  def encode(number: String): Set[List[String]] = {
    if (number.isEmpty) Set(List())
    else (for {
      split <- 1 to number.length
      word <- wordsForNum(number.take(split))
      rest <- encode(number drop split)
    } yield word :: rest).toSet
  };System.out.println("""encode: (number: String)Set[List[String]]""");$skip(26); val res$1 = 
  
  encode("7225247386");System.out.println("""res1: Set[List[String]] = """ + $show(res$1));$skip(106); 
  
  def translate (number: String): Set[String] = {
  encode(number).map(list => list.mkString(" "))
  };System.out.println("""translate: (number: String)Set[String]""");$skip(29); val res$2 = 
  
  translate("7225247386");System.out.println("""res2: Set[String] = """ + $show(res$2))}
  //

  //

  //

  //
}
