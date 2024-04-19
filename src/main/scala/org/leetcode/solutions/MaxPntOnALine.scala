package org.leetcode.solutions


import scala.collection.mutable

object MaxPntOnALine extends App {

  def maxPoints(points: Array[Array[Int]]): Int = {

    if (points.length <= 2) return points.length

    var maxCount = 0
    for (i <- 0 until points.length - 1) {
      val slopeCount = mutable.Map[Double, Int]()
      var overlapping = 0
      var currentMax = 0

      for (j <- i + 1 until points.length) {
        val x1 = points(i)(0)
        val y1 = points(i)(1)
        val x2 = points(j)(0)
        val y2 = points(j)(1)

        if (x1 == x2 && y1 == y2) {
          overlapping += 1
        } else {
          val slope = if (x1 == x2) Double.PositiveInfinity else (y2 - y1).toDouble / (x2 - x1).toDouble
          slopeCount.put(slope, slopeCount.getOrElse(slope, 0) + 1)
          currentMax = Math.max(currentMax, slopeCount(slope))
        }
      }
      maxCount = Math.max(maxCount, currentMax + overlapping + 1)
    }

    maxCount

  }

  val arr = Array(Array(1,1), Array(3,2), Array(5,3), Array(4,1), Array(2,3), Array(1,4))

  val n = maxPoints(arr)

  println(n)
}
