package programmers.level1

class Solution010104 {
    fun solution(number: IntArray): Int {
        val totalNum = number.size
        var count = 0
        for (i in 0 until totalNum) {
            for (j in i+1 until totalNum) {
                for (k in j+1 until totalNum) {
                    if (number[i] + number[j] + number[k] == 0) count++
                }
            }
        }
        return count
    }
}