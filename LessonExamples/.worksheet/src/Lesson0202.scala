object Lesson0202 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(63); 
  println("Welcome to the Scala worksheet");$skip(166); 

  def sum(f: Int => Int): (Int, Int) => Int = {
      def sumF(a: Int, b: Int): Int = {
        if (a > b) 0
        else f(a) + sumF(a + 1, b)
      }
    sumF
  };System.out.println("""sum: (f: Int => Int)(Int, Int) => Int""");$skip(29); 

  def sumInts = sum(x => x);System.out.println("""sumInts: => (Int, Int) => Int""");$skip(37); 
  def sumCubes = sum(x => x * x * x);System.out.println("""sumCubes: => (Int, Int) => Int""");$skip(17); val res$0 = 

  sumInts(1, 2);System.out.println("""res0: Int = """ + $show(res$0));$skip(17); val res$1 = 
  sumCubes(1, 2);System.out.println("""res1: Int = """ + $show(res$1));$skip(48); val res$2 = 
  //crraazy

  //Even worse
  sum(x => x)(1, 2);System.out.println("""res2: Int = """ + $show(res$2));$skip(28); val res$3 = 
  sum(x => x * x * x)(1, 2);System.out.println("""res3: Int = """ + $show(res$3));$skip(113); 

  //morecompact
  def sum2(f: Int => Int)(a: Int, b: Int): Int =
    if (a > b) 0 else f(a) + sum2(f)(a + 1, b);System.out.println("""sum2: (f: Int => Int)(a: Int, b: Int)Int""");$skip(394); 

  //However, you cannot do the intermediate step,
  // def sumInts = sum(x => x)
  //using this code.

  //==============
  //Actual Exercise
  //==============
  //1.  Write a product function that calculates the product of the values of a function
  // fro the points on a given interval

  def product(f: Int => Int)(a: Int, b: Int): Int =
    if (a > b) 1 else f(a) * product(f)(a + 1, b);System.out.println("""product: (f: Int => Int)(a: Int, b: Int)Int""");$skip(37); val res$4 = 

  //144
  product(x => x * x)(3, 4);System.out.println("""res4: Int = """ + $show(res$4));$skip(89); 

  //2.  Write factorial in terms of product

  def fact(n: Int) = product(x => x)(1, n);System.out.println("""fact: (n: Int)Int""");$skip(21); val res$5 = 
  
  //120
  fact(5);System.out.println("""res5: Int = """ + $show(res$5));$skip(242); 

  //3.  Write a general function that encompasses sum and product
  def mapReduce(f: Int => Int, combiner: (Int, Int) => Int,empty: Int)(a: Int, b: Int): Int =
    if (a > b) empty
     else combiner(f(a),mapReduce(f,combiner,empty)(a+1,b));System.out.println("""mapReduce: (f: Int => Int, combiner: (Int, Int) => Int, empty: Int)(a: Int, b: Int)Int""");$skip(85); 

  def product2(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f,(x,y)=>x*y,1)(a,b);System.out.println("""product2: (f: Int => Int)(a: Int, b: Int)Int""");$skip(46); 
   
   def fact2(n:Int) = product2(x=>x)(1,n);System.out.println("""fact2: (n: Int)Int""");$skip(29); val res$6 = 
   
   product2(x=>x*x)(3,4);System.out.println("""res6: Int = """ + $show(res$6));$skip(13); val res$7 = 
    fact2(5);System.out.println("""res7: Int = """ + $show(res$7))}
  //

  //

}
