package arrays

/**
 * Given a 2-d array A of size M*N ,containing  digits from 0-9
 * 2 cells are adjacent if they share a common edge.It is possible to move from one cell to another
 * only if they are adjacent. Find the largest group of cells such that
 * 1) you can get from any cell in the group to any other cell by moving through cells in the group
 * 2) the difference between the largest and smallest value cells in the group is 1
 * Note: The solution written might be only partially right
 */

private fun findLargestGroup(A: Array<IntArray>): Int {
    var largestValueSize = 1
    val visited = Array(A.size) { BooleanArray(A[0].size) }

    for (i in A.indices) {
        for (j in A[0].indices) {
            if (!visited[i][j]) {
                val currentGroup = mutableListOf<Int>()
                dfs(A, visited, i, j, currentGroup, A[i][j])
                largestValueSize = Math.max(currentGroup.size, largestValueSize)
            }
        }
    }
    return largestValueSize
}


private fun dfs(
    grid: Array<IntArray>, visited: Array<BooleanArray>, x: Int, y: Int, currentGroup: MutableList<Int>, smallest: Int
) {
    if (visited[x][y]) return
    visited[x][y] = true
    currentGroup.add(grid[x][y])

    if (isValid(grid, visited, x, y, x, y - 1, Math.min(smallest, grid[x][y]))) dfs(
        grid, visited, x, y - 1, currentGroup, Math.min(smallest, grid[x][y])
    )
    if (isValid(grid, visited, x, y, x, y + 1, Math.min(smallest, grid[x][y]))) dfs(
        grid, visited, x, y + 1, currentGroup, Math.min(smallest, grid[x][y])
    )
    if (isValid(grid, visited, x, y, x - 1, y, Math.min(smallest, grid[x][y]))) dfs(
        grid, visited, x - 1, y, currentGroup, Math.min(smallest, grid[x][y])
    )
    if (isValid(grid, visited, x, y, x + 1, y, Math.min(smallest, grid[x][y]))) dfs(
        grid, visited, x + 1, y, currentGroup, Math.min(smallest, grid[x][y])
    )
}

private fun isValid(
    grid: Array<IntArray>, visited: Array<BooleanArray>, x: Int, y: Int, newX: Int, newY: Int, smallest: Int
): Boolean {
    return newX >= 0 && newX < grid.size && newY >= 0 && newY < grid[0].size && !visited[newX][newY] && (Math.abs(grid[x][y] - grid[newX][newY]) == 0 || Math.abs(
        grid[x][y] - grid[newX][newY]
    ) == 1) && (grid[newX][newY] - smallest) in 0..1
}


fun main() {
    val grid = arrayOf(
        intArrayOf(3, 3, 5, 6),
        intArrayOf(6, 7, 2, 2),
        intArrayOf(5, 2, 3, 8),
        intArrayOf(5, 9, 2, 3),
        intArrayOf(1, 2, 3, 4)
    )
    val largestGroup = findLargestGroup(grid)

    println("Largest Group of Cells size:  $largestGroup")
}