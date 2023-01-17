package programmers.level1

class Solution011701 {
    fun solution(n: Int, m: Int): IntArray {
        val nDivisorList = divisor(n)
        val mDivisorList = divisor(m)
        val greatestCommonDivisor = nDivisorList.filter {
            it in mDivisorList
        }.maxOrNull()!!
        val leastCommonMultiple = greatestCommonDivisor * (n/greatestCommonDivisor) * (m/greatestCommonDivisor)
        return intArrayOf(greatestCommonDivisor, leastCommonMultiple)
    }

    fun divisor(num: Int): List<Int> {
        return (1..Math.sqrt(num.toDouble()).toInt()).filter {
            num % it == 0
        }.flatMap {
            listOf(it, num/it)
        }
    }
}