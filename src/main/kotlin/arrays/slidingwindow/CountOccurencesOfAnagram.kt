package arrays.slidingwindow

import string.isAnagram

/**
 * Given a word and a text, return the count of occurrences of the anagrams of the word in the text.
 */
fun main() {
    println("Occurence count text:gotxxotgxdogt   word:got ")
    println(getOccurenceCount("gotxxotgxdogt", "got"))

    println("Occurence count text:arrtobcanbotmanttobbto   word:tob ")
    println(getOccurenceCount("arrtobcanbotmanttobbto", "tob"))
}


fun getOccurenceCount(text: String, word: String): Int {
    val size = word.length
    var count = 0
    for (i in 0..text.length - size) {
        if (isAnagram(word, text.slice(i until i + size))) count++
    }
    return count
}