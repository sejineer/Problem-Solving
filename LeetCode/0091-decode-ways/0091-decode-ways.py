class Solution:
    def numDecodings(self, s: str) -> int:
        cur, nxt = 1, 0
        for start in reversed(range(len(s))):
            if s[start] == "0":
                cur, nxt = 0, cur
            elif start + 1 < len(s) and int(s[start : start + 2]) < 27:
                cur, nxt = cur + nxt, cur
            else:
                nxt = cur
        return cur
        