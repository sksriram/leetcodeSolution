package org.leetcode.solutions

object CoinChange extends App {

  def coinChange(coins: Array[Int], amount: Int): Int = {

    var dp: Array[Int] = List.fill[Int](amount+5)(amount+1).toArray
    dp(0) = 0
    for(i <- 1 to amount)
    {
      for(j <- 0 until coins.length)
      {
        if(coins(j) <= i)
        {
          dp(i) = dp(i) min (dp(i - coins(j)) + 1)
        }
      }
    }
    if(dp(amount) > amount ) -1 else dp(amount)


  }

  val coins = Array(1,2,5)
  val amount = 11
  val coinsReq = coinChange(coins, amount)

  println(coinsReq)


}
