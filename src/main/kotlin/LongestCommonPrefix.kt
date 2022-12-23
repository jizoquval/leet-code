fun main() {
    val a1 = arrayOf("flow", "flower", "flight")
    println(longestCommonPrefix(a1))

    val a2 = arrayOf("flower", "flow", "flight")
    println(longestCommonPrefix(a2))

    val a3 = arrayOf("xerq", "x")
    println(longestCommonPrefix(a3))
}

fun longestCommonPrefix(strings: Array<String>): String {
    if (strings.isEmpty()) return ""
    var prefix = strings.first()

    for (i in 1 until strings.size) {
        while (strings[i].indexOf(prefix) != 0) {
            prefix = prefix.substring(0, prefix.length - 1)
            if (prefix.isEmpty()) return ""
        }
    }

    return prefix
}