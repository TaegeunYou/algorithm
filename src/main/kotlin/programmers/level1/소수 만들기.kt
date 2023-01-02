package programmers.level1

class Solution010201 {
    fun solution(nums: IntArray): Int {
        var count = 0
        for (i in nums.indices) {
            for (j in i+1 until nums.size) {
                for (k in j+1 until nums.size) {
                    val num = nums[i] + nums[j] + nums[k]
                    var isPrimeNumber = true
                    for (l in 1..Math.sqrt(num.toDouble()).toInt()) {
                        if (l != 1 && num != l && num % l == 0) {
                            isPrimeNumber = false
                            break
                        }
                    }
                    if (isPrimeNumber) count++
                }
            }
        }
        return count
    }
}