package programmers.level1

class Solution010301 {
    fun solution(t: String, p: String): Int {
        return Array(t.length - p.length + 1) { idx ->
            t.substring(idx until idx + p.length)
        }.count {
            p >= it
        }
    }
}