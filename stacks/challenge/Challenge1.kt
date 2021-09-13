package challenge

import LinkedList
import stacks.StackImpl

// Challenge #1: Reversing a LinkedList without recursion
fun <T: Any> LinkedList<T>.printInReverse() {
    val stack = StackImpl<T>()
    for (node in this) {
        stack.push(node)
    }

    var node = stack.pop()
    while (node != null) {
        println(node)
        node = stack.pop()
    }
}