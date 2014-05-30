package patmat

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import patmat.Huffman._

@RunWith(classOf[JUnitRunner])
class HuffmanSuite extends FunSuite {
  trait TestTrees {
    val t1 = Fork(Leaf('a', 2), Leaf('b', 3), List('a', 'b'), 5)
    val t2 = Fork(Fork(Leaf('a', 2), Leaf('b', 3), List('a', 'b'), 5), Leaf('d', 4), List('a', 'b', 'd'), 9)
  }

  test("sort leaves"){
    val timesList = times(List('h', 'u', 'f', 'f', 'm', 'a', 'n', 'e', 's', 't', 'c', 'o', 'o', 'l', 'm', 'm', 'm', 'a', 'a', 'c'))
    //    println(timesList)
    //    println(makeOrderedLeafList(timesList))
    //    println()
  }

  test("weight of a larger tree") {
    new TestTrees {
      assert(weight(t1) === 5)
    }
  }

  test("chars of a larger tree") {
    new TestTrees {
      assert(chars(t2) === List('a', 'b', 'd'))
    }
  }

  test("string2chars(\"hello, world\")") {
    assert(string2Chars("hello, world") === List('h', 'e', 'l', 'l', 'o', ',', ' ', 'w', 'o', 'r', 'l', 'd'))
  }

  test("makeOrderedLeafList for some frequency table") {
    assert(makeOrderedLeafList(List(('t', 2), ('e', 1), ('x', 3))) === List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 3)))
  }

  test("combine of some leaf list") {
    val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
    assert(combine(leaflist) === List(Fork(Leaf('e', 1), Leaf('t', 2), List('e', 't'), 3), Leaf('x', 4)))
  }

  test("check example code"){
    val testTree = createCodeTree(List[Char]('m', 'm', 'm', 'a', 'a', 'c'))
    //    println(testTree)
    //    println(decode(testTree, List(1, 0, 1, 0, 0)))
    //    println()
  }

  test("decode and encode a very short text should be identity") {
    new TestTrees {
      assert(decode(t1, encode(t1)("ab".toList)) === "ab".toList)
    }
  }

  test("check quickEncode"){
    val testTree = createCodeTree(List[Char]('m', 'm', 'm', 'a', 'a', 'c'))
    //    println(convert(testTree))
  }

  test("test quickencode"){
    assert(quickEncode(frenchCode)(List('h', 'u', 'f', 'f', 'm', 'a', 'n', 'e', 's', 't', 'c', 'o', 'o', 'l')) === List(0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1))
  }

  test("official combine test"){
    println()
    println()
    println("====bad test ====")
    val chars = string2Chars("aabbbdddd")
    val tree = createCodeTree(chars)

    assert (tree.toString() === "Fork(Leaf(d,4),Fork(Leaf(a,2),Leaf(b,3),List(a, b),5),List(d, a, b),9)")
  }

  test("offical times test2"){
    val charList = List('k', 'r', 'k', 'd', 'r', 'r', 'b', 'b', 'b', 'a', 'a', 'a', 'b', 'a', 'a')
    val targetList = List(('a', 5), ('b', 4), ('r', 3), ('k', 2), ('d', 1))
    assert(times(charList) === targetList)
  }

  test("times permutability"){
    val charList = List('k', 'r', 'k', 'd', 'r', 'r')
    val targetList = List(('r', 3), ('k', 2), ('d', 1))
    assert(times(charList) === targetList)
    charList.permutations.foreach(possible => assert(times(possible) === targetList))
  }

  test("createCodeTree efficiency") {
    testCodeTreeEfficiency("someText", 22)
    testCodeTreeEfficiency("Huffman est cool", 58)
    testCodeTreeEfficiency("Huffman coding is a compression algorithm that can be used to compress lists of characters.", 373)
  }

  private def testCodeTreeEfficiency(text: String, length: Int) {
    val someTextCodeTree = createCodeTree(text.toList)
    assert(encode(someTextCodeTree)(text.toList).length === length)
  }
}
