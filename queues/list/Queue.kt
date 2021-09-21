package list

interface Queue<T> {
    fun enqueue(element: T): Boolean

    fun dequeue(): T?

    val count: Int
        get

    val isEmpty: Boolean
        get() = count == 0

    fun peek(): T?
}

fun <T> Queue<T>.nextPlayer(): T? {
    val person = this.dequeue() ?: return null

    this.enqueue(person)

    return person
}

fun <T: Any> Queue<T>.reverse() {
    val aux = StackImpl<T>()

    var next = this.dequeue()
    while (next != null) {
        aux.push(next)
        next = this.dequeue()
    }

    next = aux.pop()
    while (next != null) {
        this.enqueue(next)
        next = aux.pop()
    }
}