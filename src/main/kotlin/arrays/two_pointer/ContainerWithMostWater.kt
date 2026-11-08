package arrays.two_pointer

/**
 * https://leetcode.com/problems/container-with-most-water/
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 *
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 *
 * Return the maximum amount of water a container can store.
 *
 * Notice that you may not slant the container.
 *
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The  vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water  the container can contain is 49.
 * Example 2:
 *
 * Input: height = [1,1]
 * Output: 1
 *
 * Idea is 2 use a two pointer approach, one pointer at the start and one at the end of the array. Calculate the area and move the pointer with the smaller height towards the other pointer. Repeat until the pointers meet.
 */

fun main() {
    println("Max area for input [1,8,6,2,5,4,8,3,7] is: ")
    println(maxArea(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)))
    println("Max area for input [1,1] is: ")
    println(maxArea(intArrayOf(1, 1)))
}


private fun maxArea(height: IntArray): Int {
    var left = 0
    var right = height.size - 1
    var maxArea = 0

    while (left < right) {
        val area = (right - left) * minOf(height[left], height[right])
        maxArea = maxOf(maxArea, area)

        if (height[left] < height[right]) {
            left++
        } else {
            right--
        }
    }

    return maxArea
}