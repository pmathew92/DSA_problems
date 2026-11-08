package strings

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 * Given a string s, return the longest palindromic substring in s.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: s = "cbbd"
 * Output: "bb"
 *
 * Idea is to expand from the center of the palindrome and check for both odd and even length palindromes.
 */

fun main() {
    println("Longest palindromic substring for babad is: ")
    println(longestPalindrome("babad"))
    println("Longest palindromic substring for cbbd is: ")
    println(longestPalindrome("cbbd"))
    println("Longest palindromic substring for a is: ")
    println(longestPalindrome("a"))
    println("Longest palindromic substring for ac is: ")
    println(longestPalindrome("ac"))
}

private fun longestPalindrome(s: String): String {

    var result = ""
    for (index in s.indices) {
        var temp1 = expand(s, index, index)
        if (temp1.length > result.length) {
            result = temp1
        }

        temp1 = expand(s, index, index + 1)
        if (temp1.length > result.length) {
            result = temp1
        }
    }
    return result

}

private fun expand(s: String, leftIndex: Int, rightIndex: Int): String {

    var left = leftIndex
    var right = rightIndex

    while (left >= 0 && right < s.length && s[left] == s[right]) {
        left--
        right++
    }

    return s.substring(left + 1, right)
}