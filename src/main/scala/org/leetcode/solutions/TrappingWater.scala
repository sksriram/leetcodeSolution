package org.leetcode.solutions

object TrappingWater extends App {

  def trap(height: Array[Int]): Int = {
      var left = 0
      var right = height.length - 1
      var leftMax = 0
      var rightMax = 0
      var water = 0
      while (left < right) {
        leftMax = Math.max(leftMax, height(left))
        rightMax = Math.max(rightMax, height(right))
        if (leftMax < rightMax) {
          water += leftMax - height(left)
          left += 1
          } else {
            water += rightMax - height(right)
            right -= 1
             }
       }
    water
  }
  val height = Array(0, 1, 0,2,1,0,1,3,2,1,2,1)
  val water = trap(height)
  println(water)
}
