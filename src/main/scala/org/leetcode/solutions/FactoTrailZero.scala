package org.leetcode.solutions

object FactoTrailZero extends App {

  def trailingZeroes(n: Int): Int = {
    if (n == 0) return 0

    var count = 0
    var num = n
    while (num >= 5) {
      count += num / 5
      num /= 5
    }

    count

  }

  println(trailingZeroes(9))

}
