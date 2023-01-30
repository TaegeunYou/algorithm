package programmers.level1

class Solution013001 {
    fun solution(s: String): String {
        return s.split(" ").map { tmpS ->
            String(CharArray(tmpS.length) { idx ->
                if (idx % 2 == 0) tmpS[idx].uppercaseChar() else tmpS[idx].lowercaseChar()
            })
        }.joinToString(" ")
    }
}