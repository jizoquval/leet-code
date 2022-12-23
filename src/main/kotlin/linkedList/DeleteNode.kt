package linkedList

// https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/553/
fun main() {
    val node5 = LList(5, LList(1, LList(9, null)))
    val list = LList(4, node5)

    deleteNode(node5)
    println(list)
}

private fun deleteNode(node: LList) {
    node.next?.also { next ->
        node.value = next.value
        node.next = next.next
    }
}