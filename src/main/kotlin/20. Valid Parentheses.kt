/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 */
fun main() {
    // Because LeetCode use old kotlin 1.3.10
    class StackLeetCode<T> {
        private val array = mutableListOf<T>()

        val isEmpty: Boolean
            get() = array.isEmpty()

        fun pop(): T? = if (array.isEmpty()) null else array.removeAt(array.lastIndex)

        fun push(value: T) {
            array.add(value)
        }
    }

    class Stack<T> {
        private val array = mutableListOf<T>()

        val isEmpty: Boolean
            get() = array.isEmpty()

        fun pop(): T? = array.removeLastOrNull()

        fun push(value: T) {
            array.add(value)
        }
    }

    class Solution1 {

        private val pairs = mapOf(
            '(' to ')',
            '{' to '}',
            '[' to ']'
        )

        fun isValid(s: String): Boolean {
            val stack = StackLeetCode<Char>()

            loop@ for (char in s) {
                when (char) {
                    '(', '{', '[' -> stack.push(char)
                    ')', '}', ']' -> {
                        val topBracket = stack.pop()
                        if (topBracket == null || pairs[topBracket] == char) {
                            // Because LeetCode use old kotlin 1.3.10
                            continueloop@ Unit
                        } else {
                            return false
                        }
                    }
                }
            }
            return stack.isEmpty
        }
    }

    class Solution2 {

        fun isValid(s: String): Boolean {
            val stack = StackLeetCode<Char>()

            for (char in s) {
                when (char) {
                    '(' -> stack.push(')')
                    '{' -> stack.push('}')
                    '[' -> stack.push(']')
                    else -> {
                        val topElement = stack.pop()
                        if (topElement == null || topElement != char) {
                            return false
                        }
                    }
                }
            }
            return stack.isEmpty
        }
    }

    val s = Solution2()
    println("Expect )( false: ${s.isValid(s = ")(")}")
    println("Expect () true: ${s.isValid(s = "()")}")
    println("Expect ()[()]{} true: ${s.isValid(s = "()[()]{}")}")
    println("Expect (] false: ${s.isValid(s = "(]")}")
    println("Expect (]) false: ${s.isValid(s = "(])")}")
    println("Expect [(]) false: ${s.isValid(s = "[(])")}")
}