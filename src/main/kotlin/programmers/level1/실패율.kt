package programmers.level1

class Solution010203 {
    fun solution(N: Int, stages: IntArray): IntArray {
        val totalPeopleNum = stages.size
        val successPeopleNumArray = IntArray(N+1) { 0 }
        val failPeopleNumArray = IntArray(N+1) { 0 }
        val failPercentPeopleNumArray = DoubleArray(N+1) { 0.0 }
        stages.forEach {
            for (i in 1 ..it) {
                if (i != N+1) {
                    successPeopleNumArray[i]++
                    if (i == it) failPeopleNumArray[i]++
                }
            }
        }
        for (i in failPeopleNumArray.indices) {
            if (failPeopleNumArray[i] == 0 && i+1 < failPeopleNumArray.size) {
                successPeopleNumArray[i+1] = totalPeopleNum
            } else break
        }
        repeat(N+1) {
            if (successPeopleNumArray[it] == 0) failPercentPeopleNumArray[it] = 0.0
            else failPercentPeopleNumArray[it] = failPeopleNumArray[it].toDouble() / successPeopleNumArray[it].toDouble()
        }
        return failPercentPeopleNumArray.mapIndexed { idx, it ->
            Pair(it, idx)
        }.filterIndexed { idx, it -> idx != 0 }.sortedBy { it.second }.sortedByDescending { it.first }.map { it.second }.toIntArray()
    }
}