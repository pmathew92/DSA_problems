package misc

/**
 * An implementation of Lru cache using Doubly linked list
 */
class LruCache<K, V>(private val capacity: Int) {

     class Node<K, V>(val key: K, var value: V) {
        var next: Node<K, V>? = null
        var previous: Node<K, V>? = null
    }

    private val cache = HashMap<K, Node<K, V>>(capacity)
    private var head: Node<K, V>? = null
    private var tail: Node<K, V>? = null

    fun put(key: K, value: V) {
        if (cache.containsKey(key)) {
            val node = cache[key]!!
            node.value = value
            moveToFront(node)
            return
        }

        if (cache.size == capacity) {
            cache.remove(tail?.key)
            removeNode(tail!!)
        }
        val newNode = Node(key, value)
        cache[key] = newNode
        addFirst(newNode)
    }

    fun get(key: K): V? {
        if (cache.containsKey(key)) {
            val node = cache[key]!!
            moveToFront(node)
            return node.value
        }
        return null
    }


    fun remove(key: K) {
        val node = cache[key]
        node?.let {
            removeNode(node)
        }
        cache.remove(key)
    }

    fun reset() {
        cache.clear()
        while (head != null) {
            head = head?.next
            head?.previous = null
        }
        tail?.previous = null
    }

    fun dump() {
        var pointer = head
        while (pointer != null) {
            println(" ${pointer.key} : ${pointer.value}")
            pointer = pointer.next
        }
        println("================")
    }

    private fun addFirst(node: Node<K, V>) {
        node.next = head
        node.previous = null
        head?.previous = node
        head = node
        if (tail == null) tail = node
    }

    private fun removeNode(node: Node<K, V>) {
        val prevNode = node.previous
        val nextNode = node.next

        if (prevNode != null) {
            prevNode.next = nextNode
        } else {
            head = nextNode
        }

        if (nextNode != null) {
            nextNode.previous = prevNode
        } else {
            tail = prevNode
        }
    }

    private fun moveToFront(node: Node<K, V>) {
        removeNode(node)
        addFirst(node)
    }
}

fun main() {
    val cache = LruCache<Int, Int>(3)

    cache.put(1, 100)
    cache.put(2, 200)
    cache.put(3, 300)
    cache.dump()      //prints  3 : 300     2 : 200    1 : 100
    cache.put(4, 400)
    cache.dump()   //prints  4 : 400    3 : 300    2 : 200
    println(cache.get(3)) //prints 300
    cache.dump()  //prints  3 : 300    4 : 400     2 : 200
}

fun String.name(){
    println(this)
}
