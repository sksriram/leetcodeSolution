package org.leetcode.solutions

import scala.collection.mutable.{PriorityQueue}

object KthLargestElement extends App {

  def findKthLargest(nums: Array[Int], k: Int): Int = {
    val pq = PriorityQueue.empty(Ordering[Int].reverse)
    for(i <- 0 until nums.size){
      if (i < k) pq.enqueue(nums(i))
      else {
        pq.enqueue(nums(i))
        pq.dequeue()
      }
    }
    pq.dequeue()
  }

  val numsArray = Array(3,2,1,5,6,4)
  val k = 2

  val kthLarge = findKthLargest(numsArray, k)

  println(k)

}
