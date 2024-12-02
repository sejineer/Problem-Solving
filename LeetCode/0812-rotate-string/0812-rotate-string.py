from collections import deque

class Solution:
    def rotateString(self, s: str, goal: str) -> bool:
        deq = deque(s)
        print(deq)
        for _ in range(len(s)):
            first = deq.popleft()
            deq.append(first)
            if ''.join(deq) == goal:
                return True
        return False
            
        