package org.leetcode.solutions

object MergeIntervals extends App {

  def merge(intervals: Array[Array[Int]]): Array[Array[Int]] = {
      val sortedIntervals = intervals.sortBy(_(0))
      var merged = List[Array[Int]]()
      for (interval <- sortedIntervals) {
      if (merged.isEmpty || merged.last(1) < interval(0)) {

        merged = merged :+ interval
      } else {

        merged.last(1) = merged.last(1) max interval(1)
      }
    }

    merged.toArray
  }

  val interArr = Array(Array(1,3), Array(2,6), Array(8,10), Array(15,18))
  val merArr = merge(interArr)
  merArr.foreach(row => println(row.mkString("[", ", ", "]")))
}
