class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        if(len(nums) == 0):
            return 0
        nums = list(set(nums))
        nums.sort()
        d = [0 for _ in range(len(nums))]
        d[0] = 1
        for i in range(1, len(nums)):
            if nums[i] - nums[i - 1] == 1:
                d[i] = d[i - 1] + 1
            else:
                d[i] = 1
        return max(d)
        
        