package strings

fun main() {
println(" Is malayalam palindrome : ${validPalindrome("malayalam")}")
println(" Is Malayalam palindrome : ${validPalindrome("Malayalam")}")
println(" Is riddle palindrome : ${validPalindrome("riddle")}")
}


private fun validPalindrome(s: String): Boolean {

    if (s.isEmpty()) return false
    var start = 0
    var end = s.length - 1
    while (start <= end) {
       if (s[start].lowercaseChar()!= s[end].lowercaseChar()) return false
        start++
        end--
    }
    return true
}