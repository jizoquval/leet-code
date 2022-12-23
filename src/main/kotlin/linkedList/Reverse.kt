package linkedList

// https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/560/
fun main() {
    val list = LList(1, LList(2, LList(3, LList(4, null))))
    println(reverseList(list))
}

private fun reverseList(head: LList?): LList? {
    var curr = head
    var prev: LList? = null
    var next: LList?

    while (curr != null) {
        next = curr.next
        curr.next = prev
        prev = curr
        curr = next
    }
    return prev
}