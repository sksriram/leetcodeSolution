package org.leetcode.solutions

object ContainerWithMostWater extends App {

  def maxArea(height: Array[Int]): Int = {
    var maxWater = 0
    var left = 0
    var right = height.length - 1

    while (left < right) {
      var minHeight = height(left).min(height(right))
      var dist = right - left
      var capacity = minHeight * dist
      if (capacity > maxWater) {
        maxWater = capacity
      }

      if (height(left) < height(right)){
        left += 1
      }
      else {
        right -= 1
      }
    }

    return maxWater

  }

  val heightArray = Array(1,8,6,2,5,4,8,3,7)

  val amtWater = maxArea(heightArray)
  println(amtWater)

}
