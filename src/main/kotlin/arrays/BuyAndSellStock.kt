package arrays


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