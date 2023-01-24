package programmers.level2

class Solution012402 {
    fun solution(s: String): String {
        return s.split(" ").joinToString(" ") {
            if (it.isEmpty()) ""
            else "${it.first().uppercase()}${it.drop(1).lowercase()}"
        }
    }
}