package challenge

import stacks.StackImpl

// Challenge2 - Check for balanced parentheses
fun String.checkParentheses(): Boolean {
    val stack = StackImpl<Char>()
    for (character in this) {
        when (character) {
            '(' -> stack.push(character)
            ')' -> if (stack.isEmpty) {
                return false
            } else {
                return true
            }
        }
    }
    return stack.isEmpty
}