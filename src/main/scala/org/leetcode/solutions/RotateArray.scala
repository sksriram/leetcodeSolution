package org.leetcode.solutions

object RotateArray extends App {

  def rotate(nums: Array[Int], k: Int): Unit = {
    val n = nums.length
     def rotateHelper(k: Int): Unit = {
      if (k > 0) {
        val lastElement = nums(n - 1)
        for (i <- (1 until n).reverse) {
          nums(i) = nums(i - 1)
        }
        nums(0) = lastElement
        rotateHelper(k - 1)
      }
    }
    val normalizedK = k % n
    rotateHelper(normalizedK)
    println(nums.mkString(", "))
  }

  val arr = Array(1,2,3,4,5,6,7)
  rotate(arr, 3)

}
