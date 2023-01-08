package programmers.level1

/**
 * 1. 빌려줄 수 있음 -1
 * 2. 빌려줄 수는 없지만 있음(빌려줄 수 있는데 잃어버림, 애초에 안 잃어버림) -2
 * 3. 잃어버림 0
 */
class Solution010801 {
    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        val reserveList = reserve.filter {
            it !in lost
        }
        val lostList = lost.filter {
            it !in reserve
        }
        val arr = IntArray(n) {
            if (it + 1 in reserveList) -1
            else if (it + 1 in lostList) 0
            else -2
        }
        arr.forEachIndexed { idx, it ->
            if (it == -1) {
                if (idx-1 >= 0 && arr[idx-1] == 0) {
                    arr[idx-1] = -2
                } else if (idx+1 <= arr.lastIndex && arr[idx+1] == 0) {
                    arr[idx+1] = -2
                }
            }
        }
        return arr.count {
            it != 0
        }
    }
}