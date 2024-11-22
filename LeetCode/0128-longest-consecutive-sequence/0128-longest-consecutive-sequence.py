class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        num_set = set(nums)
        result = 0

        for i in nums:
            if i - 1 not in num_set:
                length = 1
                while i + length in num_set:
                    length += 1
                result = max(result, length)
        return result
     