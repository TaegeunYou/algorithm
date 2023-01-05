package programmers.level1

class Solution010503 {
    fun solution(k: Int, score: IntArray): IntArray {
        val arr = ArrayDeque<Int>()
        return score.map {
            arr.add(it)
            if (arr.size > k) arr.remove(arr.minOrNull()!!)
            arr.minOrNull()!!
        }.toIntArray()
    }
}