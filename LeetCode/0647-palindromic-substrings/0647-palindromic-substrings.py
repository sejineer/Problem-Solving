class Solution:
    def countSubstrings(self, s: str) -> int:
        res = 0
        def count_palindrom(left: int, right: int):
            count = 0
            while left >= 0 and right < len(s) and s[left] == s[right]:
                count += 1
                left -= 1
                right += 1
            return count
        
        for i in range(len(s)):
            res += count_palindrom(i, i)
            res += count_palindrom(i, i + 1)
        return res
                    
