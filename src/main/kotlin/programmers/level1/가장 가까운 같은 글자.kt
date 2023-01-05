package programmers.level1

class Solution010501 {
    fun solution(s: String): IntArray {
        val str = s.reversed()
        return IntArray(str.length) { idx ->
            str.substring(idx+1 .. str.lastIndex).indexOfFirst {
                str[idx] == it
            }.let {
                if (it != -1) it + 1
                else it
            }
        }.reversedArray()
    }
}