/**
 * Given a string s consisting of words and spaces, return the length of the last word in the string.
 * A word is a maximal substring consisting of non-space characters only.
 *
 * Input: s = "Hello World"
 * Output: 5
 * Explanation: The last word is "World" with length 5.
 */
fun main() {

    fun lengthOfLastWord(s: String): Int {
        return s.trim().split(" ").lastOrNull()?.length ?: 0
    }

    fun lengthOfLastWord2(s: String): Int {
        var length = 0
        loop@ for (index in s.indices.reversed()) {
            if (s[index] == ' ' && length > 0) {
                break@loop
            } else if (s[index] != ' ') {
                length++
            }
        }
        return length
    }


    println(lengthOfLastWord2("  Hellossss world   555555 "))
}