/**
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
 * representing the number of elements in nums1 and nums2 respectively.
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
 * To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged,
 * and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 *
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 * Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
 * The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
 */
fun main() {
    // size of nums1 == m + n
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        // Проходим с конца 2 массив, сравниваем с концом первого.
        // Вставляем в первыймассив элемент из первого или второго массива, двигая указатели
        // До конца первого массива

        var lastIndexSecond = n - 1
        var lastIndexFirst = m - 1
        var positionForInsert = m + n - 1

        while (positionForInsert >= 0) {
            if (lastIndexSecond >= 0 && lastIndexFirst >= 0 && nums2[lastIndexSecond] >= nums1[lastIndexFirst]) {
                nums1[positionForInsert] = nums2[lastIndexSecond]
                positionForInsert--
                lastIndexSecond--
            } else if (lastIndexFirst >= 0) {
                nums1[positionForInsert] = nums1[lastIndexFirst]
                positionForInsert--
                lastIndexFirst--
            } else if (lastIndexSecond >= 0) {
                nums1[positionForInsert] = nums2[lastIndexSecond]
                positionForInsert--
                lastIndexSecond--
            }
        }
    }

//    val a1 = intArrayOf(1, 2, 3, 0, 0, 0)
//    val a2 = intArrayOf(2, 5, 6)
//    merge(a1, 3, a2, 3)
//    println(a1.contentToString())

    // 1 1 2 3 4 4
    val a3 = intArrayOf(1, 4, 4, 0, 0, 0)
    val a4 = intArrayOf(1, 2, 3)
    merge(a3, 3, a4, 3)
    println(a3.contentToString())

}