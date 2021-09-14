package linkedlist

class DoublyLinkedList<T: Any> {

    private var head: Node<T>? = null
    private var tail: Node<T>? = null

    fun isEmpty(): Boolean {
        return head == null
    }

    fun append(value: T) {
        val newNode = Node(value = value, previous = tail)
        if (isEmpty()) {
            head = newNode
            tail = newNode
        }

        tail?.next = newNode
        tail = newNode
    }

    fun node(index: Int): Node<T>? {
        var currentNode = head
        var currentIndex = 0

        while (currentNode != null && currentIndex < index) {
            currentNode = currentNode.next
            currentIndex++
        }

        return currentNode
    }

    fun remove(node: Node<T>): T {
        val prevNode = node.previous
        val nextNode = node.next

        if (prevNode != null) {
            prevNode.next = nextNode
        } else {
            head = nextNode
        }

        nextNode?.previous = prevNode

        if (nextNode == null) {
            tail = prevNode
        }

        node.previous = null
        node.next = null
        
        return node.value
    }

    val first: Node<T>?
        get() = head

    override fun toString(): String {
        if (isEmpty()) {
            return "Empty list"
        }

        return head.toString()
    }
}