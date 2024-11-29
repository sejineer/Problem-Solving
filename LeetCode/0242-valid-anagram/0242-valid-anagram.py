from collections import Counter

class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        counter_s = Counter(s)
        counter_t = Counter(t)
        if len(counter_s) != len(counter_t):
            return False
        for key, value in counter_s.items():
            if counter_t[key] != value:
                return False
        return True
            