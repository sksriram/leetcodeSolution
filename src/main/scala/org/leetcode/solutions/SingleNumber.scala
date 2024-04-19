package org.leetcode.solutions

object SingleNumber extends App{

   def singleNum(nums : Array[Int]) : Int ={
     nums.distinct.filter(x => nums.filter(_ == x).length != 2)(0)

   }

   val arr = Array(3,6,8,2,6,3,2)

  println(singleNum(arr))

}
