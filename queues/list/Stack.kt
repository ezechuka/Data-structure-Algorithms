package list

interface Stack<Element> {
    fun push(element: Element)

    fun pop(): Element?

    fun peek(): Element?

    val count: Int
        get

    val isEmpty: Boolean
        get() = count == 0
}

class StackImpl<T: Any>: Stack<T> {

    companion object {
        fun <T: Any> create(items: Iterable<T>): Stack<T> {
            val stack = StackImpl<T>()
            for (item in items) {
                stack.push(item)
            }
            return stack
        }
    }

    private val storage = arrayListOf<T>()

    override fun push(element: T) {
        storage.add(element)
    }

    override fun pop(): T? {
        if (isEmpty) {
            return null
        }
        return storage.removeAt(count - 1)
    }

    override fun peek(): T? {
        return storage.lastOrNull()
    }

    override val count: Int
        get() = storage.size

    override fun toString(): String {
        return buildString {
            appendln("----top----")
            storage.asReversed().forEach {
                appendln("$it")
            }
            appendln("-------------")
        }
    }
}

fun <Element: Any> stackOf(vararg elements: Element): Stack<Element> {
    return StackImpl.create(elements.toList())
}