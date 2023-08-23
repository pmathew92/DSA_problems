package misc

/**
 * A simple implementation of Lru cache using [LinkedHashMap]
 */
class LruCacheHashMap<K, V>(private val capacity: Int) {

    private val linkedHashMap: LinkedHashMap<K, V> = object : LinkedHashMap<K, V>(capacity, 0.75f, true) {
        /**
         * This is overriden method ensures the oldest element in the map is cleared when the size exceeds the
         * capacity when a put operation is being performed
         */
        override fun removeEldestEntry(eldest: MutableMap.MutableEntry<K, V>?): Boolean {
            return size > capacity
        }
    }

    /**
     * Insert element to the cache
     */
    fun put(key: K, value: V) {
        linkedHashMap[key] = value
    }

    /**
     * Fetch and element from the cache
     */
    fun get(key: K): V? {
        if (linkedHashMap.containsKey(key)) {
            val value: V = linkedHashMap[key]!!
            linkedHashMap.remove(key)
            linkedHashMap[key] = value
        }
        return linkedHashMap[key]
    }

    /**
     * Delete an element from the cache
     */
    fun delete(key: K) {
        linkedHashMap.remove(key)
    }

    /**
     * Reset the cache
     */
    fun reset() {
        linkedHashMap.clear()
    }

    /**
     * A helper method to print all the items currently in the map
     */
    fun dump() {
        println(linkedHashMap)
        linkedHashMap.forEach { t, u ->
            println(" ${t} : $u")
        }
    }
}


fun main() {
    val cache = LruCacheHashMap<Int, Int>(3)

    cache.put(1, 100)
    cache.put(2, 200)
    cache.put(3, 300)
    cache.dump() //prints {1=100, 2=200, 3=300}
    cache.put(4, 400)
    cache.dump() //prints {2=200, 3=300, 4=400}
    println(cache.get(3)) //prints 300
    cache.dump() //prints {2=200, 4=400, 3=300}
}