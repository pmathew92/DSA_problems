package arrays.slidingwindow

/**
 * Given a string, find the length of the longest possible substring in it that has exactly K distinct characters.
 * If there is no possible substring then print -1. You can assume that K is less than or equal to the length of the given string.
 */

fun main() {
    println("Longest substring with 3 unique values for aabacbebebe is: ")
    println(findLengthOfLongestSubstringWithKUniqueCharacters("aabacbebebe", 3))
    println("Longest substring with 2 unique values for abcbdbdbbdcdabd is: ")
    println(findLengthOfLongestSubstringWithKUniqueCharacters("abcbdbdbbdcdabd", 2))
    println("Longest substring with 2 unique values for aaaa is: ")
    println(findLengthOfLongestSubstringWithKUniqueCharacters("aaaa", 2))
}


private fun findLengthOfLongestSubstringWithKUniqueCharacters(s: String, k: Int): Int {
    var longestSubstringLength = -1
    val characterMap = mutableMapOf<Char, Int>()
    var windowStart = 0
    for (i in s.indices) {
        val char = s[i]
        characterMap.put(char, characterMap.getOrDefault(char, 0) + 1)

        while (characterMap.size > k) {
            characterMap.put(s[windowStart], characterMap[s[windowStart]]!! - 1)
            if (characterMap[s[windowStart]] == 0) {
                characterMap.remove(s[windowStart])
            }
            windowStart++
        }

        if (characterMap.size == k) {
            longestSubstringLength = Math.max(longestSubstringLength, i - windowStart + 1)
        }
    }
    return longestSubstringLength
}