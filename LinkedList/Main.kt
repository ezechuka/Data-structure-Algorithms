fun main(args: Array<String>) {
    // creating and linking nodes example
    println("-----Example of creating and linking nodes-----")
    val node1 = Node(value = 1)
    val node2 = Node(value = 2)
    val node3 = Node(value = 3)

    node1.next = node2
    node2.next = node3

    println(node1)

    println("-----Example of push operation----")
    val list1 = LinkedList<Int>()
    list1.push(3).push(2).push(1)

    println(list1)

    println("-----Example of append operation----")
    val list2 = LinkedList<Int>()
    list2.append(1).append(2).append(3)

    println(list2)

    println("-----Example of inserting at a particular index-----")
    val list3 = LinkedList<Int>()
    list3.push(3)
    list3.push(2)
    list3.push(1)
    println("Before inserting: $list3")
    var middleNode = list3.nodeAt(1)!!
    for (i in 1..3) {
        middleNode = list3.insert(-1 * i, middleNode)
    }
    println("After inserting: $list3")

    println("----Example of pop----")
    val list4 = LinkedList<Int>()
    list4.push(3)
    list4.push(2)
    list4.push(1)

    println("Before popping list: $list4")
    val poppedValue = list4.pop()
    println("After popping list: $list4")
    println("Popped value: $poppedValue")

    println("-----Example of removing the last node----")
    val list5 = LinkedList<Int>()
    list5.push(3)
    list5.push(2)
    list5.push(1)

    println("Before removing last node: $list5")
    val removedValue = list5.removeLast()

    println("After removing last node: $list5")
    println("Removed value: $removedValue")

    println("-----Example of removing a node at a particular index----")
    val list6 = LinkedList<Int>()
    list6.push(3)
    list6.push(2)
    list6.push(1)

    println("Before removing at a particular index: $list6")
    val index = 1
    val node = list6.nodeAt(index - 1)!!
    val removedValue1 = list6.removeAfter(node)

    println("After removing at index $index: $list6")
    println("Removed value: $removedValue1")

    println("----Example of printing doubles----")
    val list7 = LinkedList<Int>()
    list7.push(3)
    list7.push(2)
    list7.push(1)

    for (item in list7) {
        println("Double: ${item * 2}")
    }

    println("---Example of removing elements----")
    val list8: MutableCollection<Int> = LinkedList<Int>()
    list8.add(3)
    list8.add(2)
    list8.add(1)

    println(list8)
    list8.remove(1)
    println(list8)

    println("---Example of retaining elements---")
    val list9: MutableCollection<Int> = LinkedList<Int>()
    list9.add(3)
    list9.add(2)
    list9.add(1)
    list9.add(4)
    list9.add(5)

    println(list9)
    list9.retainAll(listOf(3, 4, 5))
    println(list9)

    println("---Example of removing all elements---")
    val list10: MutableCollection<Int> = LinkedList<Int>()
    list10.add(3)
    list10.add(2)
    list10.add(1)
    list10.add(4)
    list10.add(5)

    println(list10)
    list10.removeAll(listOf(3, 4, 5))
    println(list10)

    println("----Example of print in reverse---")
    val list11 = LinkedList<Int>()
    list11.add(3)
    list11.add(2)
    list11.add(1)
    list11.add(4)
    list11.add(5)
    println(list11)
    list11.printInReverse()

    println("---Example of print middle----")
    val list12 = LinkedList<Int>()
    list12.add(6)
    list12.add(4)
    list12.add(3)
    list12.add(2)
    list12.add(1)
    println(list12)
    println(list12.getMiddle()?.value)

    println("---Example of reverse list---")
    val list13 = LinkedList<Int>()
    list13.add(6)
    list13.add(4)
    list13.add(3)
    list13.add(2)
    list13.add(1)
    println(list13)
    println("Original: $list13")
    println("Reversed: ${list13.reversed()}")

    println("---Example of merge lists----")
    val list14 = LinkedList<Int>()
    list14.add(1)
    list14.add(2)
    list14.add(3)
    list14.add(4)
    list14.add(5)


    val other = LinkedList<Int>()
    other.add(-1)
    other.add(0)
    other.add(2)
    other.add(2)
    other.add(7)

    println("Left: $list14")
    println("Right: $other")
    println("Merged: ${list14.mergeSorted(other)}")
}