package array

/**
 * In -> array of numbers (can contain negatives and zeros)
 * Out -> array with same size as in. Elements is multiplication of all elements except its
 *
 * [1, 2, 3, 4] -> [24, 12, 8, 6]
 */
fun main() {
    println(transform2(intArrayOf(1, 2, 3, 4)).contentToString())
    println(transform2(intArrayOf(1, 0, 3, 4)).contentToString())
}

// Memory O(n)
// Time O(n^2)
private fun transform(arr: IntArray): IntArray {
    val newArray = IntArray(arr.size)

    for (curIndex in arr.indices) {
        newArray[curIndex] = arr.reduceIndexed { index, acc, value ->
            if (curIndex == index) {
                acc
            } else {
                acc * value
            }
        }
    }

    return newArray
}

/**
 * left -> [1, 1, 2, 6]
 * right -> [1, 4, 12, 24]
 *
 * Space O(n)
 * Time O(n)
 */
private fun transform2(arr: IntArray): IntArray {
    val newArray = IntArray(arr.size)

    val left = IntArray(arr.size) { 1 }
    val right = IntArray(arr.size) { 1 }
    val reversedArr = arr.reversedArray()

    for (i in 1 until left.size) {
        left[i] = left[i - 1] * arr[i - 1]
    }
    for (i in 1 until right.size) {
        right[i] = right[i - 1] * reversedArr[i - 1]
    }
    right.reverse()
    for (i in arr.indices) {
        newArray[i] = left[i] * right[i]
    }
    return newArray
}