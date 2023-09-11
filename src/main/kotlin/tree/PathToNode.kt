package tree


/**
 * Program to print the path from root to a node
 */
fun main() {
    val root = TreeNode<Int>(1)
    root.left = TreeNode<Int>(2)
    root.right = TreeNode<Int>(3)
    root.left?.left = TreeNode<Int>(4)
    root.left?.right = TreeNode<Int>(5)
    root.left?.right?.left = TreeNode<Int>(6)
    root.left?.right?.right = TreeNode<Int>(7)
    val pathList = mutableListOf<Int>()
    getPath(root, pathList, 7)


    println("The path from root to node 7 is $pathList")

    val pathList1 = mutableListOf<Int>()
    getPath(root, pathList1, 4)


    println("The path from root to node 4 is $pathList1")

}


private fun getPath(node: TreeNode<Int>?, array: MutableList<Int>, value: Int): Boolean {
    node ?: return false

    array.add(node.value)
    if (node.value == value) return true

    if (getPath(node.left, array, value) || getPath(node.right, array, value)) return true

    array.removeLast()
    return false
}