package programmers.level1

class Solution010401 {
    fun solution(food: IntArray): String {
        return IntArray(food.size - 1) {
            food[it + 1] / 2
        }.foldIndexed("") { idx, total, element ->
            total + "${idx+1}".repeat(element)
        }.let {
            it + "0" + it.reversed()
        }
    }
}