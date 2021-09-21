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