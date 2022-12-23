package array

fun main() {
    try {
        /*
            0, 0, 1, 1, 1, 2, 2, 3, 3, 4
            0, 1, 2, 1, 1, 2, 2, 3, 3, 4

            0, 4, 1, 1, 1, 2, 2, 3, 3, 0
         */
        val array = intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)
        val expected = intArrayOf(0, 1, 2, 3, 4)
        val newSize = removeDuplicates(array)
        check(newSize == 5)
        for (i in 0 until newSize) {
            check(array[i] == expected[i])
        }
        println("Success")
    } catch (ex: Exception) {
        println("Failed")
    }
}

private fun removeDuplicates(nums: IntArray): Int {
    var copiedElements = 0
    var index = 0

    while (index < nums.size) {
        while (index + 1 < nums.size && nums[index] == nums[index + 1]) {
            index++
        }

        val nextIndex = index + 1
        if (nextIndex < nums.size) {
            nums[++copiedElements] = nums[nextIndex]
        }
        index++
    }
    return copiedElements + 1
}