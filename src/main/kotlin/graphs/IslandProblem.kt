package graphs


/**
 * The Island count problem
 * An island is a group of adjacent values that are all 1s.
 * Every cell in M can be adjacent to the 4 cells that are next to it on the same row or column.
 * <p>
 * https://www.ideserve.co.in/learn/number-of-clusters-of-1s
 * <p>
 * For an explanation
 * http://www.huristic.co/blog/2016/10/14/finding-islands-in-an-adjacency-matrix
 *
 * This solution uses a DFS approach. Can also be solved by BFS
 */


fun main() {

    val matrix = arrayOf(
        intArrayOf(0, 1, 0, 1, 0),
        intArrayOf(0, 0, 1, 1, 1),
        intArrayOf(1, 0, 0, 1, 0),
        intArrayOf(0, 1, 1, 0, 0),
        intArrayOf(1, 0, 1, 0, 1)
    )

    val row = matrix.size
    val column = matrix[0].size

    val count = countIslands(matrix, row, column)
    println("Total island counts are:  ${count}")
}

private fun countIslands(matrix: Array<IntArray>, row: Int, column: Int): Int {
    var count = 0

    val visitedMatrix = Array(row) { BooleanArray(column) { false } }

    for (i in 0 until row) {

        for (j in 0 until column) {
            if (matrix[i][j] == 1 && !visitedMatrix[i][j]) {
                findNeighbours(matrix, visitedMatrix, i, j)
                count++
            }
        }
    }

    return count
}

private fun findNeighbours(matrix: Array<IntArray>, visited: Array<BooleanArray>, row: Int, column: Int) {
    if (visited[row][column]) return
    visited[row][column] = true
    if (isValidNeighbour(row, column - 1, matrix)) findNeighbours(matrix, visited, row, column - 1)
    if (isValidNeighbour(row, column + 1, matrix)) findNeighbours(matrix, visited, row, column + 1)
    if (isValidNeighbour(row - 1, column, matrix)) findNeighbours(matrix, visited, row - 1, column)
    if (isValidNeighbour(row + 1, column, matrix)) findNeighbours(matrix, visited, row + 1, column)

}

private fun isValidNeighbour(row: Int, column: Int, matrix: Array<IntArray>): Boolean {
    return (row >= 0 && row < matrix.size && column >= 0 && column < matrix[0].size && matrix[row][column] == 1)
}