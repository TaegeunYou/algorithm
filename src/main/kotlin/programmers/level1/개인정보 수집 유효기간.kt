package programmers.level1

class Solution011901 {
    fun solution(today: String, terms: Array<String>, privacies: Array<String>): IntArray {
        val termsMap = terms.map {
            it.split(" ").let {
                it[0] to it[1].toInt()
            }
        }.toMap()
        return privacies.mapIndexed { idx, it ->
            val (startDate, kind) = it.split(" ").let {
                Pair(it[0], it[1])
            }
            val (startYear, startMonth, startDay) = startDate.split(".").let {
                Triple(it[0], it[1], it[2])
            }
            val endYear = (startYear.toInt() + (startMonth.toInt() + termsMap[kind]!! -1) / 12)
            val endMonth = ((startMonth.toInt() + termsMap[kind]!! - 1) % 12 + 1).let {
                if (it < 10) "0$it"
                else "$it"
            }
            val endDay = startDay
            if (today >= "$endYear.$endMonth.$endDay") idx+1 else null
        }.filterNotNull().toIntArray()
    }
}