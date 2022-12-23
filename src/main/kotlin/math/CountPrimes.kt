package math

/**
 * Given an integer n, return the number of prime numbers that are strictly less than n.
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/102/math/744/
 */
fun main() {
    println(countPrimes(2000000))
}
//
//fun countPrimes(n: Int): Int {
//    var count = 0
//    for (i in 2 until n) {
//        if (i.isPrime()) {
//            count++
//        }
//    }
//    return count
//}
//
//fun Int.isPrime(): Boolean {
//    val root = sqrt(this.toFloat()).roundToInt()
//    for (i in 2 .. root) {
//        if (this % i == 0) {
//            return false
//        }
//    }
//    return true
//}

fun countPrimes(n: Int): Int {
    var count = 1
    for (i in 3 until n) {
        if (i.isPrime()) {
            count++
        }
    }
    return count
}

val cache = mutableListOf(3)

fun Int.isPrime(): Boolean {
    for (i in cache) {
        if (this % i == 0) {
            return false
        }
    }
    cache.add(this)
    return true
}