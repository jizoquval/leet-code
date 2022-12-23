/**
 * Given an array of integers arr, return true if the number of occurrences of each value in the array is unique or false otherwise.
 *
 * Input: arr = [1,2,2,1,1,3]
 * Output: true
 * Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
 */
fun main() {
    class Solution {
        fun uniqueOccurrences(arr: IntArray): Boolean {
            val map = mutableMapOf<Int, Int>()
            arr.forEach { item ->
                map[item] = map.getOrDefault(item, 0) + 1
            }
            return map.size == map.values.toHashSet().size
        }
    }

    class Solution1 {
        fun uniqueOccurrences(arr: IntArray): Boolean {
            val map = mutableMapOf<Int, Int>()
            arr.forEach { item ->
                map[item] = map.getOrDefault(item, 0) + 1
            }
            val set = hashSetOf<Int>()
            map.values.forEach { value ->
                if (!set.add(value)) {
                    return false
                }
            }
            return true
        }
    }

    val s = Solution1()
    println(s.uniqueOccurrences(intArrayOf(1, 2, 2, 1, 1, 3)))
}
