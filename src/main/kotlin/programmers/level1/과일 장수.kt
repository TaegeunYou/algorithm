package programmers.level1

class Solution010502 {
    fun solution(k: Int, m: Int, score: IntArray): Int {
        val list = score.sorted().reversed()
        return (0 until list.size/m).sumOf {
            val minNumIdx = it * m + m - 1
            if (list.lastIndex >= minNumIdx) list[minNumIdx]
            else 0
        } * m
    }
}