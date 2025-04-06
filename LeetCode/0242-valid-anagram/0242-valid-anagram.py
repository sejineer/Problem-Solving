from collections import Counter

class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
            
        s_counter = Counter(s)
        t_counter = Counter(t)

        for num, freq in t_counter.items():
            if s_counter[num] != freq:
                return False
        
        return True
