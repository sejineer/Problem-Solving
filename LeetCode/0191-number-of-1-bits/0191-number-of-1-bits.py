class Solution:
    def hammingWeight(self, n: int) -> int:
        result = 1
        while n // 2 != 0:
            a = n // 2
            b = n % 2
            result += b
            n = a
        return result