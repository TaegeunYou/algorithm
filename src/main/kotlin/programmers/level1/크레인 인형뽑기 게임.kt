package programmers.level1

class Solution011101 {
    fun solution(board: Array<IntArray>, moves: IntArray): Int {
        val box = (board.lastIndex downTo 0).map { listIdx ->
            board.map {
                it[listIdx]
            }.filter {
                it != 0
            }.reversed().toMutableList()
        }.reversed().toMutableList()
        val newBox = ArrayDeque<Int>()
        var answer = 0
        moves.forEach { doll ->
            box[doll-1].removeLastOrNull()?.also {
                if (newBox.lastOrNull() == it) {
                    newBox.removeLast()
                    answer += 2
                } else newBox.addLast(it)
            }
        }
        return answer
    }
}