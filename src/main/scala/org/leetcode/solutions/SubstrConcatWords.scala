package org.leetcode.solutions

import scala.collection.mutable.HashSet

object SubstrConcatWords extends App {
  def findSubstring(s: String, words: Array[String]): List[Int] = {

    if(s.isEmpty || words.isEmpty) return Nil
    val l1 = s.length
    val l2 = words.map(_.length).sum
    val targets = words.permutations.map(_.mkString).toSet

    val hash_targets = new HashSet[String]()
    val it = targets.iterator
    while(it.hasNext){
      hash_targets.add(it.next())
    }

    (for (i <- 0 to (l1 - l2) if targets.contains(s.substring(i, i+l2))) yield i).toList

  }

  val str = "barfoothefoobarman"
  val words = Array("foo", "bar")

  val n = findSubstring(str, words)

  println(n)

}
