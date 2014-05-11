object Lesson0202 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  def sum(f: Int => Int): (Int, Int) => Int = {
      def sumF(a: Int, b: Int): Int = {
        if (a > b) 0
        else f(a) + sumF(a + 1, b)
      }
    sumF
  }                                               //> sum: (f: Int => Int)(Int, Int) => Int

  def sumInts = sum(x => x)                       //> sumInts: => (Int, Int) => Int
  def sumCubes = sum(x => x * x * x)              //> sumCubes: => (Int, Int) => Int

  sumInts(1, 2)                                   //> res0: Int = 3
  sumCubes(1, 2)                                  //> res1: Int = 9
  //crraazy

  //Even worse
  sum(x => x)(1, 2)                               //> res2: Int = 3
  sum(x => x * x * x)(1, 2)                       //> res3: Int = 9

  //morecompact
  def sum2(f: Int => Int)(a: Int, b: Int): Int =
    if (a > b) 0 else f(a) + sum2(f)(a + 1, b)    //> sum2: (f: Int => Int)(a: Int, b: Int)Int

  //However, you cannot do the intermediate step,
  // def sumInts = sum(x => x)
  //using this code.

  //==============
  //Actual Exercise
  //==============
  //1.  Write a product function that calculates the product of the values of a function
  // fro the points on a given interval

  def product(f: Int => Int)(a: Int, b: Int): Int =
    if (a > b) 1 else f(a) * product(f)(a + 1, b) //> product: (f: Int => Int)(a: Int, b: Int)Int

  //144
  product(x => x * x)(3, 4)                       //> res4: Int = 144

  //2.  Write factorial in terms of product

  def fact(n: Int) = product(x => x)(1, n)        //> fact: (n: Int)Int
  
  //120
  fact(5)                                         //> res5: Int = 120

  //3.  Write a general function that encompasses sum and product
  def mapReduce(f: Int => Int, combiner: (Int, Int) => Int,empty: Int)(a: Int, b: Int): Int =
    if (a > b) empty
     else combiner(f(a),mapReduce(f,combiner,empty)(a+1,b))
                                                  //> mapReduce: (f: Int => Int, combiner: (Int, Int) => Int, empty: Int)(a: Int,
                                                  //|  b: Int)Int

  def product2(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f,(x,y)=>x*y,1)(a,b)
                                                  //> product2: (f: Int => Int)(a: Int, b: Int)Int
   
   def fact2(n:Int) = product2(x=>x)(1,n)         //> fact2: (n: Int)Int
   
   product2(x=>x*x)(3,4)                          //> res6: Int = 144
    fact2(5)                                      //> res7: Int = 120
  //

  //

}