package org.leetcode.solutions

import scala.collection.mutable.HashMap
import scala.collection.mutable

object MaxPntOnALine extends App {

  def maxPoints(points: Array[Array[Int]]): Int = {

    if (points.length <= 2) return points.length // If there are 0, 1, or 2 points, return the number of points

    var maxCount = 0 // Initialize the maximum count of points on the same line
    for (i <- 0 until points.length - 1) {
      val slopeCount = mutable.Map[Double, Int]() // Map to store slope and count of points with that slope
      var overlapping = 0 // Count of points overlapping with the current point
      var currentMax = 0 // Maximum count of points on the same line passing through the current point

      for (j <- i + 1 until points.length) {
        val x1 = points(i)(0)
        val y1 = points(i)(1)
        val x2 = points(j)(0)
        val y2 = points(j)(1)

        if (x1 == x2 && y1 == y2) {
          overlapping += 1 // Increment overlapping count for points with the same coordinates
        } else {
          val slope = if (x1 == x2) Double.PositiveInfinity else (y2 - y1).toDouble / (x2 - x1).toDouble
          slopeCount.put(slope, slopeCount.getOrElse(slope, 0) + 1) // Increment count for the calculated slope
          currentMax = Math.max(currentMax, slopeCount(slope)) // Update currentMax with the maximum count of points on the same line
        }
      }
      maxCount = Math.max(maxCount, currentMax + overlapping + 1) // Update maxCount considering overlapping points
    }

    maxCount

  }

  val arr = Array(Array(1,1), Array(3,2), Array(5,3), Array(4,1), Array(2,3), Array(1,4))

  val n = maxPoints(arr)

  println(n)
}
