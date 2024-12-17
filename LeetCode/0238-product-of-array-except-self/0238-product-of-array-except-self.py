class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        complement, count_zero = 1, 0
        for i in nums:
            if i == 0:
                count_zero += 1
            else:
                complement *= i
        
        result = []
        for i in nums:
            if i == 0:
                if count_zero > 1:
                    result.append(0)
                else:
                    result.append(complement)
            else:
                if count_zero > 0:
                    result.append(0)
                else:
                    result.append(complement // i)
        return result

        