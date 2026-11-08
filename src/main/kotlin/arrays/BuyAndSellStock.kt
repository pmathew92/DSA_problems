package arrays


/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 *
 *
 *
 * Example 1:
 *
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 * Example 2:
 *
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 */
fun main() {
    println("Max profit for stock is :")

    println("For input array: {7, 1, 5, 3, 6, 4} : ${buyAndSellStock(intArrayOf(7, 1, 5, 3, 6, 4))}")
    println("For input array: {7, 6, 4, 3, 1}  : ${buyAndSellStock(intArrayOf(7, 6, 4, 3, 1))}")
}


fun buyAndSellStock(prices: IntArray): Int {
    if (prices.isEmpty()) return 0
    var left = 0
    var right = 1
    var profit = 0
    while (right < prices.size) {
        if (prices[left] < prices[right]) {
            profit = Math.max(profit, prices[right] - prices[left])
        } else {
            left = right
        }
        right++
    }
    return profit
}