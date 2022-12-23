/**
 * Given an integer x, return true if x is a palindrome, and false otherwise.
 */
fun main() {
    val s = Solution2()
    println("121 - expect true: ${s.isPalindrome(121)}")
    println("-121 - expect false: ${s.isPalindrome(-121)}")
    println("10 - expect false: ${s.isPalindrome(10)}")
    println("12344321 - expect true: ${s.isPalindrome(12344321)}")
    println("123444321 - expect true: ${s.isPalindrome(123444321)}")
}

/**
 * Using string and compare chars
 * Time complexity: O(n/2) == O(n) n длинна числа
 * Space complexity: O(n) n длинна числа
 */
private class Solution1 {
    fun isPalindrome(x: Int): Boolean {
        val strX = x.toString()
        val indexes = strX.indices
        var endIndex = indexes.last

        for (index in indexes) {
            if (index == endIndex) {
                break
            }

            if (strX[index] == strX[endIndex]) {
                endIndex--
                continue
            } else {
                return false
            }
        }
        return true
    }
}

/**
 * Revert half of the number
 *
 * Complexity time: O(log10(n)) - потому что делим на 10 и итерируемся до середины
 * Complexity space: O(1)
 */
private class Solution2 {
    fun isPalindrome(x: Int): Boolean {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false
        }
        var number = x
        var reversedHalfOfNumber = 0
        while (number > reversedHalfOfNumber) {
            reversedHalfOfNumber = reversedHalfOfNumber * 10 + number % 10
            number /= 10
        }
        return number == reversedHalfOfNumber || number == reversedHalfOfNumber / 10
    }
}