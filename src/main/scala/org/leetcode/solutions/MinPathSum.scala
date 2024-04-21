package org.leetcode.solutions

object MinPathSum extends App {

  def minPathSum(grid: Array[Array[Int]]): Int = {

    val m = grid.length
    val n = grid(0).length

    val dp = Array.ofDim[Int](m, n)

    dp(0)(0) = grid(0)(0)

    for (j <- 1 until n) {
      dp(0)(j) = dp(0)(j - 1) + grid(0)(j)
    }

    for (i <- 1 until m) {
      dp(i)(0) = dp(i - 1)(0) + grid(i)(0)
    }

    for (i <- 1 until m; j <- 1 until n) {
      dp(i)(j) = grid(i)(j) + Math.min(dp(i - 1)(j), dp(i)(j - 1))
    }

    dp(m - 1)(n - 1)

  }

  val gridArray = Array(Array(1,3,1), Array(1,5,1), Array(4,2,1))

  val pathsum = minPathSum(gridArray)

  println(pathsum)

}
