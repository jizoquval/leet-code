/**
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
 * On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time.
 * However, you can buy it then immediately sell it on the same day.
 * Find and return the maximum profit you can achieve.
 */
fun main() {
    try {
        // 1, 2, 1, 2, 5
        val ex1 = intArrayOf(1, 2, 3, 4, 5)
        check(4 == maxProfit(ex1))
        val ex2 = intArrayOf(7, 1, 5, 3, 6, 4)
        check(7 == maxProfit(ex2))
        val ex3 = intArrayOf(7, 6, 4, 3, 1)
        check(0 == maxProfit(ex3))
        val ex4 = intArrayOf(2, 1, 2, 0, 1)
        check(2 == maxProfit(ex4))
        println("Success")
    } catch (ex: Exception) {
        println("Failed ${ex.message}")
    }
}

private fun maxProfit(prices: IntArray): Int {
    var profit = 0
    var buyPrice = -1

    for (i in prices.indices) {
        if (buyPrice == -1) {
            buyPrice = prices[i]
        }
        if (i + 1 >= prices.size) {
            profit += prices[i] - buyPrice
            break
        }
        if (prices[i + 1] > buyPrice && prices[i] < prices[i + 1]) {
            // hold
            continue
        } else {
            // sell by current price
            profit += prices[i] - buyPrice
            buyPrice = -1
        }
    }
    return profit
}