package tree

/**
 *  Given a Binary Search Tree (BST), find the second largest element.
 */

private var counter = 0
fun main() {
    val root = TreeNode<Int>(50)
    root.left = TreeNode<Int>(30)
    root.right = TreeNode<Int>(70)
    root.left?.left = TreeNode<Int>(20)
    root.left?.right = TreeNode<Int>(40)
    root.right?.left = TreeNode<Int>(60)
    root.right?.right = TreeNode<Int>(80)

    secondLargest(root)
}

private fun secondLargest(node: TreeNode<Int>?) {
    if (node == null || counter >= 2) {
        return
    }

    secondLargest(node.right)
    counter++

    if (counter == 2) {
        println("The second largest element is ${node.value}")
        return
    }

    secondLargest(node.left)
}