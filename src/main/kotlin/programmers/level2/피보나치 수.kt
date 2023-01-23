package programmers.level2

import java.math.BigDecimal

class Solution012301 {
    fun solution(n: Int): Int {
        val arr = ArrayDeque(listOf(BigDecimal.ZERO, BigDecimal.ONE))
        while (arr.lastIndex != n) {
            arr.add(arr[arr.lastIndex] + arr[arr.lastIndex - 1])
        }
        return arr.last().rem(1234567.toBigDecimal()).toInt()
    }
}