package stacks

import stacks.StackImpl
import stacks.stackOf

fun main(args: Array<String>) {
    println("----Example of using a stack----")
    val stack = StackImpl<Any>().apply { 
        push(1)
        push(2)
        push(3)
        push(4)
     }
     print(stack)
     val poppedElement = stack.pop()
     if (poppedElement != null) {
         println("Popped: $poppedElement")
     }
     print(stack)

     println("----Example of Initializing a stack from a list-----")
     val list = listOf("A", "B", "C", "D")
     val stack1 = StackImpl.create(list)
     print(stack1)
     println("Popped: ${stack1.pop()}")

     println("---Example of initializing a stack from an array literal example----")
     val stack2 = stackOf<Double>(1.0, 2.0, 3.0, 4.0, 5.0)
     println(stack2)
     println("Popped: ${stack2.pop()}")

    //  println("---Example of reversing a LinkedList without recursion----")
    //  val list1 = LinkedList<Int>()
    //  list1.push(1)
    //  list1.push(2)
    //  list1.push(3)
    //  list1.push(4)
    //  list1.push(5)
    //  println(list1)
    //  println("Reversing linked list")
    //  list1.printInReverse()

    println("(hel(o)llo (worl(d)))".checkParentheses())
}

fun String.checkParentheses(): Boolean {
    val stack = StackImpl<Char>()
    for (character in this) {
        when (character) {
            '(' -> stack.push(character)
            ')' -> if (stack.isEmpty) {
                return false
            } else {
                stack.pop()
            }
        }
    }
    return stack.isEmpty
}