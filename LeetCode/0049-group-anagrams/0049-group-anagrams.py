from collections import Counter, defaultdict

class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        strs_dict = defaultdict(list)
        for s in strs:
            s_counter = Counter(s)
            strs_dict[frozenset(s_counter.items())].append(s)
        
        return list(strs_dict.values())
            