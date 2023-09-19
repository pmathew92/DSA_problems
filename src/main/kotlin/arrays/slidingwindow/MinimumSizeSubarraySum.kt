package arrays.slidingwindow

/**
 * Given an array of positive integers a and a positive number K,
 * find the length of the smallest contiguous subarray whose sum is greater than or equal to K.
 * Return 0 if no such subarray exists.
 */


fun main() {
    println("Smallest subarray for input 2, 1, 4, 3, 2, 5 and sum 7 is ")
    println(findMinimumSubArraySum(intArrayOf(2, 1, 4, 3, 2, 5), 7))

    println("Smallest subarray for input 3, 4, 1, 1, 6 and sum 8 is ")
    println(findMinimumSubArraySum(intArrayOf(3, 4, 1, 1, 6), 8))
}


private fun findMinimumSubArraySum(arr: IntArray, k: Int): Int {

    var length = Int.MAX_VALUE
    var currentSum = 0
    var windowStart = 0
    for (i in arr.indices) {
        currentSum += arr[i]

        while (currentSum >= k) {
            length = Math.min(length, i - windowStart + 1)
            currentSum -= arr[windowStart]
            windowStart++
        }
    }

    return  if(length == Int.MAX_VALUE ) 0
    else length
}


