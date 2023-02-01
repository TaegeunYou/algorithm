package programmers.level1

class Solution020101 {
    fun solution(num: Int): Int {
        var n = num.toLong()
        var count = 0
        while (n != 1.toLong() && count < 500) {
            n = when (n % 2) {
                0.toLong() -> n/2
                else -> n * 3 + 1
            }
            count++
        }
        return if (n == 1.toLong()) count else -1
    }
}