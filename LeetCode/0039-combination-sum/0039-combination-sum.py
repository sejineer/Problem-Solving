class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        result = []
        def backtracking(start: int, s: int, num_list: List[int]):
            if s > target:
                return
            elif s == target:
                result.append(num_list[:])
                return
            
            for idx in range(start, len(candidates)):
                num = candidates[idx]
                num_list.append(num)
                backtracking(idx, s + num, num_list)
                num_list.pop()
        
        backtracking(0, 0, [])
        return result
            
