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

    println("---Reverse queue example----")
    val queue2 = ArrayListQueue<String>().apply { 
        enqueue("1")
        enqueue("21")
        enqueue("18")
        enqueue("42")
     }

     println("Before: $queue2")
     queue2.reverse()
     println("After: $queue2")
}