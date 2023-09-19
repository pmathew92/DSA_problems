package arrays

/**
 * Given an array of integers of size ‘n’, Our aim is to calculate the maximum sum of ‘k’ consecutive elements in the array.
 * A problem fo sliding window technique
 */

fun main() {
    println("max sum {100, 200, 300, 400}, k = 2 is ")
    println(findMaxSum(intArrayOf(100, 200, 300, 400), 2))

    println("max sum {1, 4, 2, 10, 23, 3, 1, 0, 20}, k = 4 is ")
    println(findMaxSum(intArrayOf(1, 4, 2, 10, 23, 3, 1, 0, 20), 4))
}


private fun findMaxSum(arr: IntArray, k: Int): Int {
    if (arr.size < k) return -1
    var sum = 0
    for (i in 0 until k) {
        sum += arr[i]
    }
    var maxSum = sum

    for (i in k until arr.size) {
        sum = sum + arr[i] - arr[i - k]
        maxSum = Math.max(sum, maxSum)
    }
    return maxSum
}