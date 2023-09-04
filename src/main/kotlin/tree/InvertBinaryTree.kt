package tree

/**
 * Given the root of a binary tree, invert the tree, and return its root
 */


fun main() {

    val root = TreeNode<Int>(1)
    root.left = TreeNode<Int>(2)
    root.right = TreeNode<Int>(3)
    root.left?.left = TreeNode<Int>(4)
    root.left?.right = TreeNode<Int>(5)
    root.right?.left = TreeNode<Int>(6)
    root.right?.right = TreeNode<Int>(7)
    printBinaryTree(root, "  ")
    invertBinaryTreeRecursion(root)
    println("After inverting the tree")
    printBinaryTree(root, "  ")
}

private fun invertBinaryTreeRecursion(root: TreeNode<Int>?) {
    root ?: return

    invertBinaryTreeRecursion(root.left)
    invertBinaryTreeRecursion(root.right)

    val temp = root.left
    root.left = root.right
    root.right = temp
}