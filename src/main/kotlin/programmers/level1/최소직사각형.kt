package programmers.level1

class Solution010103 {
    fun solution(sizes: Array<IntArray>): Int {
        return sizes.map {
            Pair(it.maxOrNull()!!, it.minOrNull()!!)
        }.let {
            it.maxOf { it.first } * it.maxOf { it.second }
        }
    }
}