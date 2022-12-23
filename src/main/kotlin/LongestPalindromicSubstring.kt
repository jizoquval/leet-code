private val s1 = "babad"
private val s2 = "cbbd"
private val s3 = "a"
private val s4 = "ac"

fun main() {
    println(longestPalindrome(s1))
    assert(longestPalindrome(s1) == "bab")
}

fun longestPalindrome(s: String): String {
    var maxLength: Int = 0
    val sb = StringBuilder()
    var longestPalindrome = sb.toString()

    for (left in 0..s.length) {
        for (right in s.length..0) {
            if (s[left] == s[right]) {
                sb.append(s[left])
            }
        }
    }

    return longestPalindrome
}