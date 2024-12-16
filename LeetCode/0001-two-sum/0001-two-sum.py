class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        indicies = {}
        for i, v in enumerate(nums):
            complement = target - v
            if complement in indicies:
                j = indicies[complement]
                return [j, i]
            indicies[v] = i 