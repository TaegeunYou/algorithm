package programmers.level1

class Solution010402 {
    fun solution(ingredient: IntArray): Int {
        val arr = ArrayDeque(ingredient.toList())
        var count = 0
        var tmpStartIdx = 0
        while (arr.size >= 4 && tmpStartIdx+3 <= arr.size && tmpStartIdx >= 0) {
            if (arr[tmpStartIdx] == 1
                && arr[tmpStartIdx+1] == 2
                && arr[tmpStartIdx+2] == 3
                && arr[tmpStartIdx+3] == 1) {
                count++
                arr.removeAt(tmpStartIdx+3)
                arr.removeAt(tmpStartIdx+2)
                arr.removeAt(tmpStartIdx+1)
                arr.removeAt(tmpStartIdx)
                if (tmpStartIdx < 3) {
                    tmpStartIdx = 0
                } else tmpStartIdx -= 3
            } else tmpStartIdx++
        }
        return count
    }
}
//문자열을 사용해서 하나씩 원소 더해가면서 햄버거가 만들어지면 그만큼 자르는 방식이 더 좋을 듯