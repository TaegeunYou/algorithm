package programmers.level2

import kotlin.math.pow

class Solution012701 {
    fun solution(arr: IntArray): Int {
        val finalMap = mutableMapOf<Int, Int>()
        arr.forEach {
            mutableListOf<Int>().apply {
                var tmpNum = it
                for (i in 2..it) {
                    while (tmpNum % i == 0) {
                        this.add(i)
                        tmpNum /= i
                    }
                }
            }.groupBy { it }.map {
                it.key to it.value.size
            }.forEach { (num, count) ->
                if (finalMap[num] == null || finalMap[num]!! < count) finalMap[num] = count
            }
        }
        return finalMap.toList().fold(1) { total, it ->
            total * it.first.toDouble().pow(it.second.toDouble()).toInt()
        }
    }
}