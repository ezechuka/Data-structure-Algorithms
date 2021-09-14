package list

fun main(args: Array<String>) {
    println("----Example of Queue with ArrayList----")
    val queue = ArrayListQueue<String>().apply {
        enqueue("Ray")
        enqueue("Brian")
        enqueue("Eric")
    }

    println(queue)
    queue.dequeue()
    println(queue)
    println("Next up: ${queue.peek()}")
}