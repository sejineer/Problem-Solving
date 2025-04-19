def solution(info, n, m):
    dp = [[False] * m for _ in range(n)]
    dp[0][0] = True
    
    for ai, bi in info:
        nxt = [[False] * m for _ in range(n)]
        for a in range(n):
            for b in range(m):
                if not dp[a][b]:
                    continue
                na = a + ai
                if na < n:
                    nxt[na][b] = True
                nb = b + bi
                if nb < m:
                    nxt[a][nb] = True
        dp = nxt
        
    for i in range(n):
        for j in range(m):
            if dp[i][j]:
                return i
    
    return -1
