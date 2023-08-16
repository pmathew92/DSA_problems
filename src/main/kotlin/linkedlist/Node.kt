package linkedlist

/**
 * Single node for a linked list
 */
class Node<T>(val value: T) {
    var next: Node<T>? = null
}


fun <T> printLinkedList(head: Node<T>?) {
    var pointer: Node<T>? = head
    if (head == null) {
        println("Head is null. Returning")
        return
    }
    while (pointer != null) {
        println(pointer.value)
        pointer = pointer.next
    }
}