package leetcode

class Solution012002 {
    fun buildArray(nums: IntArray): IntArray {
        return IntArray(nums.size) {
            nums[nums[it]]
        }
    }
}