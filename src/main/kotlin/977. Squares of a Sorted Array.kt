/**
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each
 * number sorted in non-decreasing order.
 *
 * [-4 -1 0 3 10] [0 1 9 16 100]
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100].
 * After sorting, it becomes [0,1,9,16,100].
 */
fun main() {
    // 1. Проходим с конца и возводим в квадрат
    // 2. Свапаем если элемент был отпрецательный пока не встанет на свое место
    // The worst case N^2
    class Solution {
        fun sortedSquares(nums: IntArray): IntArray {
            for (index in nums.indices.reversed()) {
                if (nums[index] == 0) {
                    continue
                } else if (nums[index] > 0) {
                    nums[index] = nums[index] * nums[index]
                } else {
                    val sqr = nums[index] * nums[index]
                    nums[index] = sqr
                    for (i in index + 1 until nums.size) {
                        val y = nums[i]
                        if (sqr >= y) {
                            nums[i] = sqr
                            nums[i - 1] = y
                        } else {
                            break
                        }
                    }
                }
            }
            return nums
        }
    }

    // Time complexity O(N)
    class Solution2 {
        // 2 pointers
        fun sortedSquares(nums: IntArray): IntArray {
            val result = IntArray(nums.size)

            var leftIndex = 0
            var rightIndex = nums.size - 1
            var lastInsertedIndex = rightIndex
            while (leftIndex <= rightIndex) {
                val l = nums[leftIndex] * nums[leftIndex]
                val r = nums[rightIndex] * nums[rightIndex]

                if (r >= l) {
                    result[lastInsertedIndex] = r
                    rightIndex--
                    lastInsertedIndex--
                } else {
                    result[lastInsertedIndex] = l
                    leftIndex++
                    lastInsertedIndex--
                }
            }
            return result
        }
    }

    val s = Solution2()
    println("Expected: [0,1,9,16,100] ${s.sortedSquares(intArrayOf(-4, -1, 0, 3, 10)).contentToString()}")
    println("Expected: [1] ${s.sortedSquares(intArrayOf(-1)).contentToString()}")
    println("Expected: [0, 1, 4, 9, 16] ${s.sortedSquares(intArrayOf(-4, -3, -2, -1, 0)).contentToString()}")
}