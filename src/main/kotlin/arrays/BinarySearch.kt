package arrays

/**
 * Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search
 * target in nums. If target exists, then return its index. Otherwise, return -1.
 * You must write an algorithm with 0(log n) runtime complexity.
 */
fun main() {
    println("Is element 5 present in {1,3,5,7,,9}")
    println(binarySearch(intArrayOf(1, 3, 5, 7, 9), 5))

    println("Is element 13 present in {10,15,17,19,23}")
    println(binarySearch(intArrayOf(10, 15, 17, 19, 23), 13))
}


private fun binarySearch(nums: IntArray, target: Int): Int {
    var start = 0
    var end = nums.size - 1
    while (start <= end) {
        val mid = start + (end - start) / 2
        if (nums[mid] == target) return mid
        else if (nums[mid] > target) end = -1
        else start = mid + 1
    }

    return -1
}