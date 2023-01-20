package leetcode.easy

class Solution012002 {
    fun buildArray(nums: IntArray): IntArray {
        return IntArray(nums.size) {
            nums[nums[it]]
        }
    }
}