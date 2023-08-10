package arrays

/**
 * Given an array of  integers nums and an integer target , return indices
of the two numbers such that they add up to target
You may assume that each input would have exactly one solution, and
you may not use the same element twice.
You can return the answer in any order.
 */
fun main() {
    println("Two sum examples ")
    println("input  sorted [3,4,6,8,13,15] target: 12")
    println("indices ${twoSumSorted(intArrayOf(3, 4, 6, 8, 13, 15), 12)}")
    println("input  unsorted [6,3,9,1,2,11,5] target: 14")
    println("indices ${twoSumUnSorted(intArrayOf(6, 3, 9, 1, 2, 11, 5), 14)}")
}


private fun twoSumSorted(nums: IntArray, target: Int): Pair<Int, Int> {
    var startIndex = 0
    var endIndex = nums.size - 1
    while (startIndex < endIndex) {

        if (nums[startIndex] + nums[endIndex] == target) return Pair(startIndex, endIndex)
        else if (nums[startIndex] + nums[endIndex] > target) {
            endIndex--
        } else {
            startIndex++
        }
    }
    return Pair(-1, -1)
}


private fun twoSumUnSorted(nums: IntArray, target: Int): Pair<Int, Int> {
    val map = mutableMapOf<Int, Int>()
    var otherSum = -1
    for ((index, value) in nums.withIndex()) {
        otherSum = target - value
        if (map.containsKey(otherSum) && map[otherSum] != index) return Pair(index, map[otherSum]!!)
        map[value] = index
    }
    return Pair(-1, -1)
}