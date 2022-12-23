import utils.ListNode

/**
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
 * Return the head of the merged linked list.
 *
 * In: list1 = [1,2,4], list2 = [1,3,4]
 * Out: [1,1,2,3,4,4]
 *
 * 1. Different list sizes. [1, 2, 2, 4] [1, 2, 5]
 * 2. Empty list
 */
fun main() {
    class Solution {
        /**
         *  2 pointers
         *  eq el - add both + move both pointers
         *  ela < elb - add ela + move a pointer
         *
         *  Time Complexity O(n+m)
         */
        fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
            var head1 = list1
            var head2 = list2

            var result = ListNode(0) // fake head
            var pointerToLast = result

            while (head1 != null || head2 != null) {
                when {
                    (head1 != null && head2 != null && head1.`val` < head2.`val`) || (head1 != null && head2 == null) -> {
                        pointerToLast.next = head1
                        pointerToLast = head1
                        head1 = head1.next
                    }

                    (head1 != null && head2 != null && head1.`val` > head2.`val`) || (head2 != null && head1 == null) -> {
                        pointerToLast.next = head2
                        pointerToLast = head2
                        head2 = head2.next
                    }

                    head1 != null && head2 != null && head1.`val` == head2.`val` -> {
                        pointerToLast.next = head1
                        pointerToLast = head1
                        head1 = head1.next

                        pointerToLast.next = head2
                        pointerToLast = head2
                        head2 = head2.next
                    }
                }
            }
            return result.next
        }
    }

    val s = Solution()
    val result = s.mergeTwoLists(
        list1 = ListNode(1).apply { next = ListNode(2).apply { next = ListNode(2).apply { next = ListNode(4) } } },
        list2 = ListNode(1).apply { next = ListNode(3).apply { next = ListNode(4) } }
    )
    var h = result
    while (h != null) {
        print("${h.`val`} ")
        h = h.next
    }
}