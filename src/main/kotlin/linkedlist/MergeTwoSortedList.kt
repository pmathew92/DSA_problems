import linkedlist.Node
import linkedlist.printLinkedList

/**
 * You are given the heads of two sorted linked lists
list1 and list2
Merge the two lists in a one sorted list. The list should be made by splicing
together the nodes of the first two lists.
Return the head of the merged linked list.
 */
fun main() {
    val head1: Node<Int> = Node<Int>(1)
    var pointer1: Node<Int>? = head1
    for (i in 3..9 step 2) {
        pointer1?.next = Node<Int>(i)
        pointer1 = pointer1?.next
    }


    val head2: Node<Int> = Node<Int>(2)
    var pointer2: Node<Int>? = head2
    for (i in 4..8 step 2) {
        pointer2?.next = Node<Int>(i)
        pointer2 = pointer2?.next
    }

    println("Merged linked list is :")
    val resultHead: Node<Int>? = mergeList(head1, head2)
    print(printLinkedList<Int>(resultHead))
}


fun mergeList(head1: Node<Int>?, head2: Node<Int>?): Node<Int>? {
    var pointer1 = head1
    var pointer2 = head2
    var pointer: Node<Int>? = Node<Int>(-1)
    val head: Node<Int>? = pointer
    while (pointer1 != null && pointer2 != null) {
        pointer?.next = if (pointer1.value > pointer2.value) {
            val value = pointer2.value
            pointer2 = pointer2.next
            Node(value)
        } else {
            val value = pointer1.value
            pointer1 = pointer1.next
            Node(value)
        }
        pointer = pointer?.next
    }

    while (pointer1 != null) {
        pointer?.next = Node(pointer1.value)
        pointer1 = pointer1.next
    }
    while (pointer2 != null) {
        pointer?.next = Node(pointer2.value)
        pointer2 = pointer2.next
    }
    return head?.next
}