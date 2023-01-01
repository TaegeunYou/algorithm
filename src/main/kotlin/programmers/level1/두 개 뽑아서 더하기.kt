package programmers.level1

class Solution010107 {
    fun solution(numbers: IntArray): IntArray {
        val arr = ArrayDeque<Int>()
        for (i in numbers.indices) {
            for (j in i+1 until numbers.size) {
                arr.add(numbers[i]+numbers[j])
            }
        }
        return arr.toSortedSet().toIntArray()
    }
}