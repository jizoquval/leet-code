import utils.TreeNode

/**
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 */
fun main() {
    /**
     * Time complexity: O(N) - n count of nodes
     * Space Complexity: O(N) - n count of nodes (if tree unbalanced it's the worst case)
     */
    class Solution {
        fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
            return if (p != null && q != null && p.`val` == q.`val`) {
                isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
            } else p == null && q == null
        }
    }

    val g1 = TreeNode(10).apply {
        left = TreeNode(20).apply {
            left = TreeNode(40)
        }
        right = TreeNode(30)
    }
    val g2 = TreeNode(10).apply {
        left = TreeNode(20).apply {
            left = TreeNode(50)
        }
        right = TreeNode(30)
    }
    val g3 = TreeNode(10).apply {
        left = TreeNode(20).apply {
            right = TreeNode(40)
        }
        right = TreeNode(30)
    }
    val s = Solution()
    println("Same: ${s.isSameTree(g1, g1)}")
    println("Same: ${s.isSameTree(g1, g2)}")
    println("Same: ${s.isSameTree(g1, g3)}")
}