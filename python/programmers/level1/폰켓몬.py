def solution(nums):
    count = len(set(nums))
    maxCount = len(nums) // 2
    return min(count, maxCount)