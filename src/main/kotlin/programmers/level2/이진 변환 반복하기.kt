package programmers.level2

class Solution012501 {
    fun solution(s: String): IntArray {
        var tmp = s
        var zeroCount = 0
        var count = 0
        while (tmp != "1") {
            count++
            zeroCount += tmp.count { it == '0' }
            tmp = Integer.toBinaryString(
                tmp.replace("0", "").length
            )
        }
        return intArrayOf(count, zeroCount)
    }
}