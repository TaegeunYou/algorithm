package programmers.level1

class Solution010202 {
    fun solution(a: Int, b: Int, n: Int): Int {
        var tmpNum = n
        var total = 0
        while (tmpNum >= a) {
            val new =  tmpNum/a * b
            total += new
            tmpNum = new + tmpNum % a
        }
        return total
    }
}