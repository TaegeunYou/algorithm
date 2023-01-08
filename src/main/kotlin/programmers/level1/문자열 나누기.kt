package programmers.level1

class Solution010701 {
    fun solution(s: String): Int {
        var x = ' '
        var xNum = 0
        var otherNum = 0
        var answer = 0
        s.forEachIndexed { idx, it ->
            if (x == ' ') {
                x = it
                xNum++
            } else if (it == x) {
                xNum++
            } else {
                otherNum++
            }
            if (xNum == otherNum || idx == s.lastIndex) {
                x = ' '
                xNum = 0
                otherNum = 0
                answer++
            }
        }
        return answer
    }
}
/*
fun solution010701(s: String): Int {
    var x = ' '
    var xNum = 0
    var otherNum = 0
    var answer = 0
    s.forEach {
        if (x == xNum) {
            x = it
            xNum++
        } else when (it == x) {
            true -> xNum++
            false -> otherNum++
        }
        if (xNum == otherNum) {
            x = ' '
            xNum = 0
            otherNum = 0
            answer++
        }
    }
    return if (xNum > 0) answer + 1 else answer
}
 */