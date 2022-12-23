private val matrix1 = arrayOf(
    intArrayOf(1, 2, 3),
    intArrayOf(4, 5, 6),
    intArrayOf(7, 8, 9)
)

private val matrix2 = arrayOf(
    intArrayOf(5, 1, 9, 11),
    intArrayOf(2, 4, 8, 10),
    intArrayOf(13, 3, 6, 7),
    intArrayOf(15, 14, 12, 16)
)

/**
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 *
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
 * DO NOT allocate another 2D matrix and do the rotation.
 */
fun main() {
    rotate(matrix1)
    matrix1.forEach { r ->
        println(r.contentToString())
    }
}

private fun rotate(matrix: Array<IntArray>) {
    transpose(matrix)
    reflect(matrix)
}

// Main diagonal
private fun transpose(matrix: Array<IntArray>) {
    for (i in matrix.indices) {
        for (j in matrix.indices) {
            if (i != j && i > j) {
                val temp = matrix[i][j]
                matrix[i][j] = matrix[j][i]
                matrix[j][i] = temp
            }
        }
    }
}

// Horizontal reflection
private fun reflect(matrix: Array<IntArray>) {
    val n = matrix.size - 1
    for (row in matrix) {
        for (i in row.indices) {
            val oppPos = n - i
            if (oppPos != i && oppPos > i) {
                val temp = row[i]
                row[i] = row[oppPos]
                row[oppPos] = temp
            }
        }
    }
}
