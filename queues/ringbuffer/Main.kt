package ringbuffer

fun main(args: Array<String>) {
    println("Example of Queue with ring buffer")
    val queue = RingBufferQueue<String>(10).apply { 
        enqueue("Ray")
        enqueue("Brian")
        enqueue("Eric")
     }
     println(queue)
     queue.dequeue()
     println(queue)
     println("Next up: ${queue.peek()}")
}