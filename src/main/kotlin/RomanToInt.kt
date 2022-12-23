fun main() {
    val s1 = "IV"
    println("$s1 ${convert(s1)}")

    val s2 = "MCMXCIV"
    println("$s2 ${convert(s2)}")
}

val romans = mapOf(
    'I' to 1,
    'V' to 5,
    'X' to 10,
    'L' to 50,
    'C' to 100,
    'D' to 500,
    'M' to 1000
)

fun checkCombination(current: Char, nextRoman: Char): Pair<Boolean, Int> {
    return when {
        (nextRoman == 'V' || nextRoman == 'X') && current == 'I' -> {
            true to romans[nextRoman]!! - romans[current]!!
        }

        (nextRoman == 'L' || nextRoman == 'C') && current == 'X' -> {
            true to romans[nextRoman]!! - romans[current]!!
        }

        (nextRoman == 'D' || nextRoman == 'M') && current == 'C' -> {
            true to romans[nextRoman]!! - romans[current]!!
        }

        else -> false to romans[current]!!
    }
}

fun convert(roman: String): Int {
    var index = 0
    var sum = 0
    while (index < roman.length) {
        val current = roman[index]
        val nextIndex = index + 1
        if (nextIndex < roman.length) {
            val next = roman[nextIndex]
            val (isSkipNext, value) = checkCombination(current, next)
            sum += value
            index += if (isSkipNext) {
                2
            } else {
                1
            }
        } else {
            sum += romans[current]!!
            index += 1
        }
    }
    return sum
}

fun convert2(s: String): Int {
    var sum = 0
    val length = s.length
    var i = 0
    while (i < length) {
        if (i + 1 < length && (romans[s[i]]!! < romans[s[i + 1]]!!)) {
            sum += romans[s[i + 1]]!! - romans[s[i]]!!
            i += 2
        } else {
            sum += romans[s[i]]!!
            i += 1
        }
    }
    return sum
}