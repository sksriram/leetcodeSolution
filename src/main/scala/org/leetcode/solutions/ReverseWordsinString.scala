package org.leetcode.solutions

object ReverseWordsinString extends App{

  def reverseStatement(statement: String): String = {
    val words = statement.split("\\s+")
    val reversedWords = words.reverse
    reversedWords.mkString(" ")
  }
  val s = "the sky is blue"

  println(reverseStatement(s))
}
