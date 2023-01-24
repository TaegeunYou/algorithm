package programmers.level2

class Solution012401 {
    fun solution(s: String): String {
        val numList = s.split(" ").map { it.toInt() }
        return "${numList.minOrNull()} ${numList.maxOrNull()}"
    }
}