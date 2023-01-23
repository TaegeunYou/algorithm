package programmers.level2

import java.math.BigDecimal

class Solution012201 {
    fun solution(n: Int): Long {
        return (0..n/2).sumOf {
            val numTwo = it
            val numOne = (n-it*2)
            factorial(numOne + numTwo) / (factorial(numOne) * factorial(numTwo))
        }.rem(1234567.toBigDecimal()).toLong()
    }
    private fun factorial(num: Int): BigDecimal {
        return (1..num).fold(1.toBigDecimal()) { total, i ->
            total.multiply(i.toBigDecimal())
        }
    }
}