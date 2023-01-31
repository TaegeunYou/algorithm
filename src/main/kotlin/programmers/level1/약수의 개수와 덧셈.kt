package programmers.level1

class Solution013101 {
    fun solution(left: Int, right: Int): Int {
        return (left..right).fold(0) { total, num ->
            val divisorNum = (1..Math.sqrt(num.toDouble()).toInt()).filter {
                num % it == 0
            }.flatMap {
                listOf(it, num/it)
            }.distinct().size
            total + if (divisorNum % 2 == 0) num else -num
        }
    }
}