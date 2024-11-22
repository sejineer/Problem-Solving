class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        buy = prices[0]
        res = 0
        
        for i in prices[1:]:
            if buy > i:
                buy = i
            res = max(res, i - buy)
        return res
            