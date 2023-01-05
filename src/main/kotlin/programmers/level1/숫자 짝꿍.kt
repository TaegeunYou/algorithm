package programmers.level1

class Solution010504 {
    fun solution(X: String, Y: String): String {
        val xArr = IntArray(10)
        val yArr = IntArray(10)
        X.forEach {
            xArr["$it".toInt()]++
        }
        Y.forEach {
            yArr["$it".toInt()]++
        }
        return Array(10) {
            "$it".repeat(minOf(xArr[it], yArr[it]))
        }.joinToString("").reversed().let {
            if (it.isEmpty()) -1
            else if (it.all { "$it" == "0" }) 0
            else it
        }.toString()
    }
}

/*
class Solution010504 {
    fun solution(X: String, Y: String): String {
        return IntArray(10) { num ->
            Math.min(X.filter { "$it" == "$num" }.length, Y.filter { "$it" == "$num" }.length)
        }.mapIndexed { idx, it ->
            "$idx".repeat(it)
        }.filter { it.isNotEmpty() }.joinToString("").reversed().let {
            if (it.isEmpty()) -1
            else if (it.all { "$it" == "0" }) 0
            else it
        }.toString()
    }
}
 */