package programmers.level1

class Solution010901 {

    fun solution(lottos: IntArray, win_nums: IntArray): IntArray {
        return lottos.count(win_nums::contains).let { min ->
            intArrayOf(getRank(min + lottos.count { it == 0 }), getRank(min))
        }
    }

    private fun getRank(answer: Int): Int {
        return when {
            answer >= 2 -> 7 - answer
            else -> 6
        }
    }

}