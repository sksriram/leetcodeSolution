package org.leetcode.solutions

object HouseRob extends App {

  def rob(nums: Array[Int]): Int = {
    val n = nums.length

    def robHelper(i: Int, memo: Array[Int]): Int = {
      if (i < 0) return 0
      if (memo(i) != -1) return memo(i)

      val robCurrent = nums(i) + robHelper(i - 2, memo)
      val skipCurrent = robHelper(i - 1, memo)
      memo(i) = Math.max(robCurrent, skipCurrent)
      memo(i)
    }

    val memo = Array.fill(n)(-1)
    robHelper(n - 1, memo)
  }

  val nums = Array(1,2,3,1)
  val totmon = rob(nums)
  println(totmon)

}
