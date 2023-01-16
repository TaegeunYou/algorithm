package programmers.level1

class Solution011601 {

    class User(
        val id: String,
        val reportMap: MutableMap<String, Int> = mutableMapOf()
    )

    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        val userList = id_list.map { id ->
            User(id, id_list.associateWith { 0 }.toMutableMap())
        }
        report.forEach {
            val (reporter,reported) = it.split(" ").run {
                Pair(this[0], this[1])
            }
            userList.first { it.id == reporter }.reportMap[reported] = 1
        }
        val reportList = userList.map { it.reportMap.values.toList() }
        val mailList = IntArray(id_list.size) { idx ->
            reportList.sumOf { it[idx] }
        }.map { it >= k }
        return userList.map {
            it.reportMap.values.filterIndexed { index, i ->
                i == 1 && mailList[index]
            }.size
        }.toIntArray()
    }
}