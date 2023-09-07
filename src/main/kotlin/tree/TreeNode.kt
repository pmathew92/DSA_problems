package tree

import java.util.*

/**
 * A simple node for a binary tree
 */
class TreeNode<T>(val value: T) {
    var right: TreeNode<T>? = null
    var left: TreeNode<T>? = null
}

fun <T> printBinaryTree(root: TreeNode<T>?, indent: String) {

    if (root == null) return

    println("$indent${root.value}")

    printBinaryTree(root.left, indent + "\t")
    printBinaryTree(root.right, indent + "\t")
}

//fun <T> printBinaryTree(root: TreeNode<T>?, prefix: String = "", isLeft: Boolean = false) {
//    if (root == null) {
//        return
//    }
//
//    val nodeType = if (isLeft) "L─" else "R─"
//    val marker = if (isLeft) "┌" else "└"
//
//    println("$prefix$marker${root.value}")
//
//    val newPrefix = "$prefix│  "
//    printBinaryTree(root.left, newPrefix, true)
//    printBinaryTree(root.right, newPrefix, false)
//}


/** A basic implementation of a binary tree with integer input
 */
fun main() {
    val root = populateIntegerTree()
    printBinaryTree(root, "  ")
}

fun preOrderTraversal(node: TreeNode<Int>?) {
    node ?: return
    println("Node value is ${node.value} ")
    preOrderTraversal(node.left)
    preOrderTraversal(node.right)
}

fun inOrderTraversal(node: TreeNode<Int>?) {
    node ?: return
    inOrderTraversal(node.left)
    println("Node value is ${node.value} ")
    inOrderTraversal(node.right)
}

fun postOrderTraversal(node: TreeNode<Int>?) {
    node ?: return
    postOrderTraversal(node.left)
    postOrderTraversal(node.right)
    println("Node value is ${node.value} ")
}

private fun populateIntegerTree(): TreeNode<Int> {
    println("Enter the root node")
    val scanner = Scanner(System.`in`)
    val value = scanner.nextInt()
    val root = TreeNode<Int>(value)
    populate(scanner, root)
    return root
}


private fun populate(scanner: Scanner, node: TreeNode<Int>) {
    println("Do you wish to input left node for ${node.value}")
    val isLeft = scanner.nextBoolean()
    if (isLeft) {
        println("Enter the value of the left of ${node.value}")
        val value = scanner.nextInt()
        node.left = TreeNode<Int>(value)
        populate(scanner, node.left!!)
    }

    println("Do you wish to input right node for ${node.value}")
    val isRight = scanner.nextBoolean()
    if (isRight) {
        println("Enter the value of the right of ${node.value}")
        val value = scanner.nextInt()
        node.right = TreeNode<Int>(value)
        populate(scanner, node.right!!)
    }
}