package programmers.level1

class Solution011001 {
    fun solution(numbers: IntArray, hand: String): String {
        var right = Pair(0, 0)
        var left = Pair(2, 0)
        val positionMap = mapOf(
            1 to Pair(0, 3),
            2 to Pair(1, 3),
            3 to Pair(2, 3),
            4 to Pair(0, 2),
            5 to Pair(1, 2),
            6 to Pair(2, 2),
            7 to Pair(0, 1),
            8 to Pair(1, 1),
            9 to Pair(2, 1),
            0 to Pair(1, 0),
        )
        return numbers.joinToString("") {
            when (it) {
                1, 4, 7 -> {
                    left = positionMap[it]!!
                    "L"
                }
                3, 6, 9 -> {
                    right = positionMap[it]!!
                    "R"
                }
                else -> {
                    val target = positionMap[it]!!
                    val leftDistance = Math.abs(target.first - left.first) + Math.abs(target.second - left.second)
                    val rightDistance = Math.abs(target.first - right.first) + Math.abs(target.second - right.second)
                    if ((leftDistance == rightDistance && hand == "left") || rightDistance > leftDistance) {
                        left = target
                        "L"
                    } else {
                        right = target
                        "R"
                    }
                }
            }
        }
    }
}