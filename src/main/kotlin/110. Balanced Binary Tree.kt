import utils.TreeNode
import kotlin.math.abs
import kotlin.math.max

fun main() {
    // Time complexity O(N) count of node
    class Solution {
        fun isBalanced(root: TreeNode?): Boolean {
            return subTreeHeight(root) != -1
        }

        // -1 if unbalanced
        private fun subTreeHeight(tree: TreeNode?): Int {
            if (tree == null) return 0

            val leftHeight = subTreeHeight(tree.left)
            if (leftHeight == -1) return -1

            val rightHeight = subTreeHeight(tree.right)
            if (rightHeight == -1) return -1

            if (abs(leftHeight - rightHeight) > 1) return -1
            return max(leftHeight, rightHeight) + 1
        }
    }

    // Time complexity O(N^2) - n обходов по n нодам
    class Solution2 {
        fun isBalanced(root: TreeNode?): Boolean {
            if (root == null) return true

            val left = subTreeHeight(root.left)
            val right = subTreeHeight(root.right)
            return abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right)
        }

        private fun subTreeHeight(tree: TreeNode?): Int {
            if (tree == null) return 0
            return max(subTreeHeight(tree?.left), subTreeHeight(tree?.right)) + 1
        }
    }

    val t1 = TreeNode(1).apply {
        left = TreeNode(2)
        right = TreeNode(2).apply {
            left = TreeNode(3)
            right = TreeNode(3)
        }
    }
    val t2 = TreeNode(1).apply {
        left = TreeNode(2).apply {
            left = TreeNode(3).apply {
                left = TreeNode(4)
            }
        }
        right = TreeNode(2).apply {
            right = TreeNode(3).apply {
                right = TreeNode(4)
            }
        }
    }
    val t3 = TreeNode(1).apply {
        right = TreeNode(2).apply {
            right = TreeNode(3)
        }
    }
    val t4 = TreeNode(1).apply {
        left = TreeNode(2).apply {
            left = TreeNode(3)
        }
    }
    val s = Solution()
    println("Expect true: ${s.isBalanced(t1)}")
    println("Expect false: ${s.isBalanced(t2)}")
    println("Expect false: ${s.isBalanced(t3)}")
    println("Expect false: ${s.isBalanced(t4)}")
}