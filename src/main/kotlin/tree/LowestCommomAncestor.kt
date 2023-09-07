package tree

/**
 * Program to find th lowest common ancestor(LCA) of a binary tree and a binary search tree.
 * Lowest Common Ancestor(LCA): The lowest common ancestor is defined between two nodes x and y as the lowest
 * node in T that has both x and y as descendants (where we allow a node to be a descendant of itself.
 * https://takeuforward.org/data-structure/lowest-common-ancestor-for-two-given-nodes/
 */
fun main() {

    val root = TreeNode<Int>(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left?.left = TreeNode(4)
    root.left?.right = TreeNode(5)

    root.right?.left = TreeNode(6)
    root.right?.right = TreeNode(7)


    val lca = findLCABinaryTree(root, root.left?.left!!, root.left?.right!!)
    println("Common root for the binary tree is ${lca?.value}")


    val root1 = TreeNode<Int>(20)
    root1.left = TreeNode(10)
    root1.right = TreeNode(30)
    root1.left?.left = TreeNode(5)
    root1.left?.right = TreeNode(15)

    root1.right?.left = TreeNode(25)
    root1.right?.right = TreeNode(35)


    val lca1 = findLCABinarySearchTree(root1, root1.left?.left!!, root1.left?.right!!)
    println("Common root for the binary search tree is ${lca1?.value}")

    val lca2 = findLCABinarySearchTree(root1, root1.left?.left!!, root1.right?.right!!)
    println("Common root for the binary search tree is ${lca2?.value}")
}


private fun findLCABinaryTree(root: TreeNode<Int>?, p: TreeNode<Int>, q: TreeNode<Int>): TreeNode<Int>? {
    if (root == null || root == p || root == q) {
        return root
    }

    val left = findLCABinaryTree(root.left, p, q)
    val right = findLCABinaryTree(root.right, p, q)

    return if (left == null) right
    else if (right == null) left
    else root
}


private fun findLCABinarySearchTree(root: TreeNode<Int>?, p: TreeNode<Int>, q: TreeNode<Int>): TreeNode<Int>? {
    if (root == null || root == p || root == q) {
        return root
    }

    return if (p.value < root.value && q.value < root.value) findLCABinarySearchTree(root.left, p, q)
    else if (p.value > root.value && q.value > root.value) findLCABinarySearchTree(root.right, p, q)
    else root
}