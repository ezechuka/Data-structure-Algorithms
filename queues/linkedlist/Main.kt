package linkedlist

fun main(args: Array<String>) {
    println("---Example of Queue with Doubly LinkedList----")
    val queue = LinkedListQueue<String>().apply { 
        enqueue("Ray")
        enqueue("Brian")
        enqueue("Eric")
     }
     println(queue)
     queue.dequeue()
     println(queue)
     println("Next up: ${queue.peek()}")
}