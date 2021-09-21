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

    println("Boardgame manager with Queue")
    val queue1 = ArrayListQueue<String>().apply {
        enqueue("Vincent")
        enqueue("Remel")
        enqueue("Lukiih")
        enqueue("Allison")
    }
    println(queue1)
    println("====== boardgame =====")
    queue1.nextPlayer()
    println(queue1)

    queue1.nextPlayer()
    println(queue1)

    queue1.nextPlayer()
    println(queue1)

    queue1.nextPlayer()
    println(queue1)
}