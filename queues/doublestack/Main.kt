package doublestack

fun main(args: Array<String>) {
    println("---Queue with Double Stack----")
    val queue = StackQueue<String>().apply {
        enqueue("Ray")
        enqueue("Brian")
        enqueue("Eric")
    }
    println(queue)
    queue.dequeue()
    println(queue)
    println("Next up: ${queue.peek()}")
}