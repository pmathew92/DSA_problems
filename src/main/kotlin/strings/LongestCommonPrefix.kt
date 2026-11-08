package strings

/**
 * https://leetcode.com/problems/longest-common-prefix
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 * Idea is to do a vertical scanning of the characters in the strings and check if they are equal. If they are not equal, return the prefix found so far.
 */

fun main() {
    println("Longest common prefix for [flower, flow, flight] is: ")
    println(longestCommonPrefix(arrayOf("flower", "flow", "flight")))
    println("Longest common prefix for [dog, racecar, car] is: ")
    println(longestCommonPrefix(arrayOf("dog", "racecar", "car")))
}

private fun longestCommonPrefix(strs: Array<String>): String {

    if (strs.isEmpty()) return ""
    val first = strs[0]
    for (index in strs.indices) {
        val expected = first[index]

        for (wordIndex in 1 until strs.size) {
            val word = strs[wordIndex]
            if (index >= word.length || word[index] != expected) {
                return first.substring(0, index)
            }
        }
    }
    return first
}