package string

/**
 * Given two strings s and t return true if t is an anagram of s , and false otherwise.
 * An Anagram is a word or phrase formed by rearranging the letters of a
 * different word or phrase, typically using all the original letters exactly once.
 */
fun main() {
    println("Is valid anagram Anna  & nana")
    println(isAnagram("Anna", "nana"))

    println("Is valid anagram anna  & nana")
    println(isAnagram("anna", "nana"))
}


fun isAnagram(s: String, t: String): Boolean {
    if (s.length != t.length) return false

    val characterMap = s.groupingBy { it.lowercaseChar() }.eachCount().toMutableMap()

    t.forEach {
        if (!characterMap.containsKey(it)) return false
        else {
            characterMap[it] = characterMap[it]!! - 1
        }
    }
    return characterMap.all { it.value == 0 }
}