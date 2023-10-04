package graphs

/**
 * Given a matrix of dimension M * N where each cell in the matrix can have values 0, 1 or 2 which has the following meaning:
0: Empty cell
1: Cells have fresh oranges
2: Cells have rotten oranges
Determine what is the minimum time required so that all the oranges become rotten.
A rotten orange at index (i,j ) can rot other fresh oranges which are its neighbours (up, down, left and right).
If it is impossible to rot every orange then simply return -1.
PS: Asked in Adobe 1st round.This solution is a BFS solution and can be further optimized using a Queue approach
https://www.geeksforgeeks.org/minimum-time-required-so-that-all-oranges-become-rotten/
 */


fun main() {
    val matrix = arrayOf(
        intArrayOf(2, 1, 0, 2, 1),
        intArrayOf(1, 0, 1, 2, 1),
        intArrayOf(1, 0, 0, 2, 1)
    )

    println("Minimum days to rot all oranges are: ")
    println(minimumDaysToRot(matrix))

    val matrix1 = arrayOf(
        intArrayOf(2, 1, 0, 2, 1),
        intArrayOf(0, 0, 1, 2, 1),
        intArrayOf(1, 0, 0, 2, 1)
    )

    println("Minimum days to rot all oranges are: ")
    println(minimumDaysToRot(matrix1))

}

private fun minimumDaysToRot(matrix: Array<IntArray>): Int {
    var days = 2
    var flag = false

    while (true) {
        for (i in matrix.indices) {
            for (j in 0 until matrix[0].size) {
                if (matrix[i][j] == days) {
                    if (isValid(i, j - 1, matrix) && matrix[i][j - 1] == 1) {
                        matrix[i][j - 1] = days + 1
                        flag = true
                    }
                    if (isValid(i, j + 1, matrix) && matrix[i][j + 1] == 1) {
                        matrix[i][j + 1] = days + 1
                        flag = true
                    }
                    if (isValid(i - 1, j, matrix) && matrix[i - 1][j] == 1) {
                        matrix[i - 1][j] = days + 1
                        flag = true
                    }
                    if (isValid(i + 1, j, matrix) && matrix[i + 1][j] == 1) {
                        matrix[i + 1][j] = days + 1
                        flag = true
                    }
                }
            }
        }
        if (!flag) break
        flag = false
        days++
    }

    for (i in matrix.indices) {
        for (j in 0 until matrix[0].size) {
            if (matrix[i][j] == 1) return -1
        }
    }
    return days - 2
}


private fun isValid(row: Int, column: Int, matrix: Array<IntArray>): Boolean {
    return (row >= 0 && row < matrix.size && column >= 0 && column < matrix[0].size)
}