from collections import deque

class Solution:
    def isValid(self, s: str) -> bool:
        stack = deque()
        pairs = {')': '(', '}': '{', ']': '['}

        for c in s:
            if c in '[{(':
                stack.append(c)
            else:
                if not stack or stack.pop() != pairs[c]:
                    return False
        return not stack
        