package graphs

/**
 * Flood fill problem
 * An image is represented by an m x n integer grid image where image[i][j]  represents the pixel value of the image.
 * You are also given three integers sr, sc and color. You should perform a flood fill on the image starting from the pixel
 *  image[sr][sc] . Return the modified image after performing the flood fill.
 */


fun main() {

    val originalImage = arrayOf(
        intArrayOf(1, 1, 1, 1, 1, 1, 1, 1),
        intArrayOf(1, 1, 1, 1, 1, 1, 0, 0),
        intArrayOf(1, 0, 0, 1, 1, 0, 1, 1),
        intArrayOf(1, 2, 2, 2, 2, 0, 1, 0),
        intArrayOf(1, 1, 1, 2, 2, 0, 1, 0),
        intArrayOf(1, 1, 1, 2, 2, 2, 2, 0),
        intArrayOf(1, 1, 1, 1, 1, 2, 1, 1),
        intArrayOf(1, 1, 1, 1, 1, 2, 2, 1)
    )

    val originalImage1 = arrayOf(
        intArrayOf(2, 1, 2, 2),
        intArrayOf(1, 1, 2, 3),
        intArrayOf(1, 2, 2, 2),
        intArrayOf(2, 3, 3, 2)
    )


    val modifiedImage = floodFill(originalImage, 4, 3, 3)
    val modifiedImage1 = floodFill(originalImage1, 1, 2, 0)

    println("Modified image1 is ")
    for (element in modifiedImage) {
        for (j in 0 until modifiedImage[0].size) {
            print("${element[j]}  ")
        }
        println("")
    }


    println("Modified image2 is ")
    for (element in modifiedImage1) {
        for (j in 0 until modifiedImage1[0].size) {
            print("${element[j]}  ")
        }
        println("")
    }


}

private fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {
    val visited = Array(image.size) { BooleanArray(image[0].size) { false } }
    val pixelToBeReplaced = image[sr][sc]
    findNeighbouringPixel(image, sr, sc, color, visited, pixelToBeReplaced)
    return image
}

fun findNeighbouringPixel(
    image: Array<IntArray>, row: Int, column: Int, color: Int, visited: Array<BooleanArray>, pixelToBeReplaced: Int
) {
    if (visited[row][column]) return
    visited[row][column] = true
    image[row][column] = color

    if (isValidNeighBour(image, row, column - 1, pixelToBeReplaced)) findNeighbouringPixel(
        image, row, column - 1, color, visited, pixelToBeReplaced
    )
    if (isValidNeighBour(image, row, column + 1, pixelToBeReplaced)) findNeighbouringPixel(
        image, row, column + 1, color, visited, pixelToBeReplaced
    )
    if (isValidNeighBour(image, row - 1, column, pixelToBeReplaced)) findNeighbouringPixel(
        image, row - 1, column, color, visited, pixelToBeReplaced
    )
    if (isValidNeighBour(image, row + 1, column, pixelToBeReplaced)) findNeighbouringPixel(
        image, row + 1, column, color, visited, pixelToBeReplaced
    )

}

private fun isValidNeighBour(image: Array<IntArray>, row: Int, column: Int, pixelToBeReplaced: Int): Boolean {
    return (row >= 0 && row < image.size && column >= 0 && column < image.size && image[row][column] == pixelToBeReplaced)
}

