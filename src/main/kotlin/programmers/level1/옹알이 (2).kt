package programmers.level1

class Solution010602 {
    fun solution(babbling: Array<String>): Int {
        val twoLengthList = listOf("ye", "ma")
        val threeLengthList = listOf("aya", "woo")
        var answer = 0
        babbling.forEach {
            var str = it
            var isSuccess = true
            var beforeStr = ""
            while (str.isNotEmpty()) {
                if (str.take(2) in twoLengthList) {
                    val tmpStr = str.take(2)
                    if (tmpStr == beforeStr) {
                        isSuccess = false
                        break
                    }
                    beforeStr = tmpStr
                    if (str.length == 2) str = ""
                    else if (str.length >= 3) str = str.substring(2)
                } else if (str.take(3) in threeLengthList) {
                    val tmpStr = str.take(3)
                    if (tmpStr == beforeStr) {
                        isSuccess = false
                        break
                    }
                    beforeStr = tmpStr
                    if (str.length == 3) str = ""
                    else if (str.length >= 4) str = str.substring(3)
                } else {
                    isSuccess = false
                    break
                }
            }
            if (isSuccess) answer++
        }
        return answer
    }
}
/*
fun solution(babbling: Array<String>): Int {
    return babbling.filter {
        !it.contains("ayaaya|yeye|woowoo|mama".toRegex())
    }.filter {
        it.replace("aya|ye|woo|ma".toRegex(), "").isEmpty()
    }.size
}
 */