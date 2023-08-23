package arrays

/**
 * Given an array and target find all triplets (a[i],a[j],a[k]) such that
 * a[i]+a[j]+a[k] = target and i!=j!=k.
 * solution must contain unique elements
 * This approach uses a hashmap which keeps the space complexity to O(n^2) .
 * We can also use a two pointer approach to reduce teh space complexity by sorting the array
 */

fun main() {
    println("Three sum examples ")
    println("input  [7,-6,3,8,-1,8,-11] target: 0")
    println("Values ${threeSum(intArrayOf(7, -6, 3, 8, -1, 8, -11), 0)}")
    println("input  [2,1,-2,2,-1,3,4,5,2] target: 6")
    println("Values ${threeSum(intArrayOf(2, 1, -2, 2, -1, 3, 4, 5, 2), 6)}")
}

private fun threeSum(arr: IntArray, target: Int): List<Triple<Int, Int, Int>> {

    val frequencyMap = mutableMapOf<Int, Int>()
    val finalList = mutableListOf<Triple<Int, Int, Int>>()
    arr.forEach {
        if (frequencyMap.containsKey(it)) frequencyMap[it] = frequencyMap[it]!! + 1
        else frequencyMap[it] = 1
    }

    for (i in arr.indices) {
        for (j in i + 1 until arr.size) {
            val third = target - arr[i] - arr[j]
            if (frequencyMap.containsKey(third) && third != arr[i] && third != arr[j] && frequencyMap[third] != 0 && frequencyMap[arr[i]] != 0 && frequencyMap[j] != 0) {
                finalList.add(Triple(arr[i], arr[j], third))
                frequencyMap[third] = frequencyMap[third]!!.minus(1)
                frequencyMap[arr[i]] = frequencyMap[arr[i]]!!.minus(1)
                frequencyMap[arr[j]] = frequencyMap[arr[j]]!!.minus(1)
            }
        }
    }
    return finalList

}