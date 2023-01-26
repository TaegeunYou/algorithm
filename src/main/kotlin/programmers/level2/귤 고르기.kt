package programmers.level2

class Solution012601 {
    fun solution(k: Int, tangerine: IntArray): Int {
        val map = tangerine
            .groupBy { it }
            .toList()
            .sortedByDescending { it.second.size }
        var total = 0
        var result = 0
        while (total < k) {
            total += map[result].second.size
            result++
        }
        return result
    }
}