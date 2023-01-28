package programmers.level1

class Solution012801 {

    fun solution(answers: IntArray): IntArray {

        fun score(cycle: List<Int>): Int {
            return answers.filterIndexed { idx, i ->
                i == cycle[idx % cycle.size]
            }.size
        }

        val numOne = score(listOf(1, 2, 3, 4, 5))
        val numTwo = score(listOf(2, 1, 2, 3, 2, 4, 2, 5))
        val numThree = score(listOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5))
        val maxScore = maxOf(numOne, numTwo, numThree)

        return listOf(numOne, numTwo, numThree).mapIndexedNotNull { idx, i ->
            if (i == maxScore) idx+1 else null
        }.toIntArray()
    }

}