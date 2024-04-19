package org.leetcode.solutions

object InsertInterval extends App {

  def insert(intervals: Array[Array[Int]], newInterval: Array[Int]): Array[Array[Int]] = {

    var merged = List[Array[Int]]()
    var i = 0

    while (i < intervals.length && intervals(i)(1) < newInterval(0)) {
      merged = merged :+ intervals(i)
      i += 1
    }

    var newIntervalStart = newInterval(0)
    var newIntervalEnd = newInterval(1)
    while (i < intervals.length && intervals(i)(0) <= newIntervalEnd) {
      newIntervalStart = newIntervalStart min intervals(i)(0)
      newIntervalEnd = newIntervalEnd max intervals(i)(1)
      i += 1
    }
    merged = merged :+ Array(newIntervalStart, newIntervalEnd)

    while (i < intervals.length) {
      merged = merged :+ intervals(i)
      i += 1
    }

    merged.toArray
  }

  val interArr = Array(Array(1,3), Array(6,9))
  val newInter = Array(2,5)
  val insArr = insert(interArr, newInter)
  insArr.foreach(row => println(row.mkString("[", ", ", "]")))

}
