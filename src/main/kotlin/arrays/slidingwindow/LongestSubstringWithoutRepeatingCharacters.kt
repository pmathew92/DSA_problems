package arrays.slidingwindow

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * Given a string s, find the length of the longest substring without duplicate characters.
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 *
 * Idea is to compact the window by moving the left pointer when a duplicate character is found and keep track of the maximum length of the substring without repeating characters.
 */


fun main() {
    println("Longest substring without repeating characters for abcabcbb is: ")
    println(findLengthOfLongestSubstringWithoutRepeatingCharacters("abcabcbb"))
    println("Longest substring without repeating characters for bbbbb is: ")
    println(findLengthOfLongestSubstringWithoutRepeatingCharacters("bbbbb"))
    println("Longest substring without repeating characters for pwwkew is: ")
    println(findLengthOfLongestSubstringWithoutRepeatingCharacters("pwwkew"))
}

private fun findLengthOfLongestSubstringWithoutRepeatingCharacters(s: String): Int {
    var right = 0
    var left = 0
    var maxLength = 0
    val seen = hashSetOf<Char>()

    while (right < s.length) {
        if (!seen.contains(s[right])) {
            seen.add(s[right++])
            maxLength = maxOf(maxLength, right - left)
        } else {
            seen.remove(s[left++])
        }
    }

    return maxLength

}