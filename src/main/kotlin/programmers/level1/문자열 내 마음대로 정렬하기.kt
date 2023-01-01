package programmers.level1

class Solution010105 {
    fun solution(strings: Array<String>, n: Int): Array<String> {
        return strings.sorted().sortedBy { it[n] }.toTypedArray()
    }
}