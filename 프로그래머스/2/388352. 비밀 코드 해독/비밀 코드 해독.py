def solution(n, q, ans):
    result = 0
    secret = []
    
    def dfs(k, idx):
        if k == 5:
            nonlocal result
            for i in range(len(q)):
                temp = 0
                for num in secret:
                    if num in q[i]:
                        temp += 1
                if temp != ans[i]:
                    return
            result += 1
            return
                
        for i in range(idx, n + 1):
            secret.append(i)
            dfs(k + 1, i + 1)
            secret.pop()
    dfs(0, 1)
    return result
            