from collections import deque

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dq = deque()
        visited = set()
        dq.append([0, 0])
        while len(dq) != 0:
            cur = dq.popleft()
            for num in coins:
                if cur[0] > amount: continue
                if cur[0] == amount: return cur[1]
                nxt = cur[0] + num
                if nxt not in visited:
                    visited.add(nxt)
                    dq.append([nxt, cur[1] + 1])
        return -1