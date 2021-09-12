class LinkedList<T>: Iterable<T>, Collection<T>, MutableIterable<T>, MutableCollection<T> {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    
    override var size = 0
        private set

    override fun isEmpty() : Boolean {
        return size == 0
    }

    override fun contains(element: T): Boolean {
        for (item in this) {
            if (item == element) return true
        }
        return false
    }

    override fun containsAll(elements: Collection<T>): Boolean {
        for (searched in elements) {
            if (!contains(searched)) return false
        }
        return true
    }

    fun push(value: T) : LinkedList<T> {
        head = Node(value = value, next = head)
        if (tail == null) {
            tail = head
        }
    
        size++
        return this
    }

    fun append(value: T): LinkedList<T> {
        if (isEmpty()) {
            push(value)
            return this
        }
        tail?.next = Node(value = value)
        tail = tail?.next
        size++
        return this

    }

    fun nodeAt(index: Int): Node<T>? {
        var currentNode = head;
        var currentIndex = 0;

        while (currentNode != null && currentIndex < index) {
            currentNode = currentNode.next
            currentIndex++
        }

        return currentNode
    }

    fun insert(value: T, afterNode: Node<T>): Node<T> {
        if (tail == afterNode) {
            append(value)
            return tail!!
        }

        val newNode = Node(value = value, next = afterNode.next)
        afterNode.next = newNode
        size++
        return newNode
    }

    fun pop() : T {
        if (!isEmpty()) size--
        
        val result = head?.value
        head = head?.next
        if (isEmpty()) {
            tail = null
        }
        return result!!
    }

    fun removeLast() : T? {
        val head = head ?: return null

        if (head.next == null) return pop()

        size--

        var prev = head
        var current = head

        var next = current.next
        while (next != null) {
            prev = current
            current = next
            next = current.next
        }

        prev.next = null
        tail = prev
        return current.value

    }

    fun removeAfter(node: Node<T>): T? {
        val result = node.next?.value
        if (node.next == tail) {
            tail = node
        }

        if (node.next != null) {
            size--
        }

        node.next = node.next?.next
        return result
    }

    override fun add(element: T): Boolean {
        append(element)
        return true
    }

    override fun addAll(elements: Collection<T>): Boolean {
        for (element in elements)
            append(element)
        return true
    }

    override fun clear() {
        head = null
        tail = null
        size = 0
    }

    override fun remove(element: T): Boolean {
        val iterator = iterator()
        while (iterator.hasNext()) {
            if (element == iterator.next()) {
                iterator.remove()
                return true
            }
        }
        return false
    }

    override fun removeAll(elements: Collection<T>): Boolean {
        var result = false
        for (item in elements) {
            result = remove(item) || false
        }
        return result
    }

    override fun retainAll(elements: Collection<T>): Boolean {
        var result = false
        val iterator = iterator()
        while (iterator.hasNext()) {
            val item = iterator.next()
            if (!elements.contains(item)) {
                remove(item)
                result = true
            }
        }
        return result
    }

    override fun iterator(): MutableIterator<T> {
        return LinkedListIterator(this)
    }

    override fun toString() : String {
        if (size == 0) {
            return "Empty string"
        } else {
            return head.toString()
        }
    }


    // get the item in the middle
    fun addInReverse(list: LinkedList<T>, node: Node<T>) {
        val next = node.next
        if (next != null) {
            addInReverse(list, next)
        }
        list.append(node.value)
    }

    fun <T: Comparable<T>> append(result: LinkedList<T>, node: Node<T>): Node<T>? {
        result.append(node.value)
        return node.next
    }

}

 // challenge 1
 fun <T> LinkedList<T>.printInReverse() {
    this.nodeAt(0)?.printInReverse()
}

 // get item in the middle
 fun <T> LinkedList<T>.getMiddle(): Node<T>? {
    var fast = this.nodeAt(0)
    var slow = this.nodeAt(0)

    while (fast?.next != null) {
        fast = fast.next
        if (fast != null) {
            fast = fast.next
            slow = slow?.next
        }
    }

    return slow
}

// reversing a linked list
fun <T> LinkedList<T>.reversed(): LinkedList<T> {
    val result = LinkedList<T>()
    val head = this.nodeAt(0)
    if (head != null) {
        addInReverse(result, head)
    }
    return result
}

// merging two linked lists
fun <T: Comparable<T>> LinkedList<T>.mergeSorted(otherList: LinkedList<T>): LinkedList<T> {
    if (this.isEmpty()) return otherList
    if (otherList.isEmpty()) return this

    val result = LinkedList<T>()

    var left = nodeAt(0)
    var right = otherList.nodeAt(0)

    while (left != null && right != null) {
        if (left.value < right.value) {
            left = append(result, left)
        } else {
            right = append(result, right)
        }
    }

    while (left != null) {
        left = append(result, left)
    }

    while (right != null) {
        right = append(result, right)
    }

    return result
}