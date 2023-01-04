/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 *
 * Input: n = 1
 * Output: ["()"]
 *
 * n = 2
 * [()(), (())]
 *
 * Всего 2^2n все перестановки.
 * Max str length n * 2
 */
fun main() {
    class Solution {
        fun generateParenthesis(n: Int): List<String> {
            val result = mutableListOf<String>()
            val sb = StringBuilder()
            backtrack(
                result,
                sb,
                0,
                0,
                n
            )
            return result
        }

        private fun backtrack(
            result: MutableList<String>,
            sb: StringBuilder,
            openCount: Int,
            closeCount: Int,
            max: Int,
        ) {
            // Достигли макс длинны
            if (sb.length == max * 2) {
                result.add(sb.toString())
                return
            }
            if (openCount < max) {
                sb.append('(')
                backtrack(result, sb, openCount + 1, closeCount, max)
                sb.deleteCharAt(sb.length - 1)
            }
            if (closeCount < openCount) {
                sb.append(')')
                backtrack(result, sb, openCount, closeCount + 1, max)
                sb.deleteCharAt(sb.length - 1)
            }
        }
    }

    val s = Solution()
    println(s.generateParenthesis(6))
}