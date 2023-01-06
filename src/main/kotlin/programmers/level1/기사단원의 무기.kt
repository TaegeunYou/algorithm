package programmers.level1

class Solution010601 {
    fun solution(number: Int, limit: Int, power: Int): Int {
        return (1..number).map { num ->
            val count = (1..Math.sqrt(num.toDouble()).toInt()).filter {
                num % it == 0
            }.flatMap {
                listOf(it, num/it)
            }.distinct().size
            if (count > limit) power
            else count
        }.sum()
    }
}