package arrays.slidingwindow

/**
 * Given an array of 0’s and 1’s, we need to write a program to find
 * the minimum number of swaps required to group all 1’s present in the array together.
 */
fun main() {

    println("Minimum swap required to group ones in {1, 0, 1, 0, 1 } is ${findMinimumSwap(arrayOf(1, 0, 1, 0, 1))} ")
    println(
        "Minimum swap required to group ones in {1, 0, 1, 0, 1, 1 } is ${
            findMinimumSwap(
                arrayOf(
                    1, 0, 1, 0, 1, 1
                )
            )
        } "
    )
}

private fun findMinimumSwap(arr: Array<Int>): Int {
    val windowSize = arr.count { it == 1 }

    var maxOnes = Int.MIN_VALUE
    var onesCount = 0

    for (i in 0 until windowSize) {
        if (arr[i] == 1) onesCount++
    }


    for (i in 1..arr.size - windowSize) {

        if (arr[i - 1] == 1) onesCount--

        if (arr[i + windowSize - 1] == 1) onesCount++

        if (maxOnes < onesCount) maxOnes = onesCount
    }

    return windowSize - maxOnes

}