class Solution:
    def numDecodings(self, s: str) -> int:
        dp = [0] * len(s) + [1]

        for i in reversed(range(len(s))):
            if s[i] == "0":
                dp[i] = 0
            elif i + 1 < len(s) and int(s[i : i + 2]) < 27:
                dp[i] = dp[i + 1] + dp[i + 2]
            else:
                dp[i] = dp[i + 1]
        
        return dp[0]
                