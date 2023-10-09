package arrays

/**
 * Given a Binary String of length N. It is allowed to do at most one swap between any 0 and 1.
 * The task is to find the length of the longest consecutive 1’s that can be achieved.
 */

fun main() {
    println("the longest consecutive 1's that can be achieved for {111011101}  is ${findLongestConsecutive("\"111011101\"")}")
    println("the longest consecutive 1's that can be achieved for {111000}  is ${findLongestConsecutive("\"111000\"")}")
}


private fun findLongestConsecutive(str: String): Int {
    val maxOnes = str.toCharArray().count { it == '1' }

    val leftArray = Array(str.length) { 0 }
    val rightArray = Array(str.length) { 0 }

    leftArray[0] = if (str[0] == '1') 1 else 0
    for (i in 1 until str.toCharArray().size) {
        if (str[i] == '1') leftArray[i] = leftArray[i - 1] + 1
    }

    rightArray[str.length - 1] = if (str[str.length - 1] == '1') 1 else 0
    for (i in str.length - 2 downTo 0) {
        if (str[i] == '1') rightArray[i] = rightArray[i + 1] + 1
    }

    var countOnes = 0
    var maxOne = Int.MIN_VALUE
    for (i in 1 until str.length - 1) {

        if (str[i] == '0') {
            val sum = leftArray[i - 1] + rightArray[i + 1]
            if (sum < maxOnes)
                maxOne = Math.max(maxOne, sum + 1)
            else maxOne = Math.max(maxOne, sum)
        }
    }


    return maxOne
}