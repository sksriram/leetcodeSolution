package org.leetcode.solutions

import scala.math._

object Candy extends App{

  def candy(ratings: Array[Int]): Int = {
    val n = ratings.length
    val leftToRight = Array.fill(n)(1)
    val rightToLeft = Array.fill(n)(1)

    for (i <- 1 until n) {
      if (ratings(i) > ratings(i - 1)) {
        leftToRight(i) = leftToRight(i - 1) + 1
      }
    }

    for (i <- n - 2 to 0 by -1) {
      if (ratings(i) > ratings(i + 1)) {
        rightToLeft(i) = rightToLeft(i + 1) + 1
      }
    }

    var result = 0

    for (i <- 0 until n) {
      result += Math.max(leftToRight(i), rightToLeft(i))
    }
    result
  }

  val arr = Array(1,2,2)
  val n = candy(arr)
  println(n)

}
