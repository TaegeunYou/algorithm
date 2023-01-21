package programmers.level2

class Solution012101 {
    fun solution(brown: Int, yellow: Int): IntArray {
        val sum = 2 * brown - 4
        val multi = brown + yellow

        val a = 1
        val b = -((brown - 4)/2 + 4)
        val c = (brown + yellow)
        println("$a $b $c")

        val column = ((-b + Math.sqrt((b * b - 4 * a * c).toDouble()))/ (2 * a)).toInt()
        return intArrayOf(column, sum - column)
    }
}