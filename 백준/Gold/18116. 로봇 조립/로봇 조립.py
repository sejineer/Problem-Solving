import sys
input = sys.stdin.readline

n = int(input())
p = [-1] * 1_000_001

def find(x: int) -> int:
    if p[x] < 0:
        return x
    p[x] = find(p[x])
    return p[x]

def union(u: int, v: int) -> bool:
    u = find(u)
    v = find(v)
    if u == v:
        return False
    if p[u] > p[v]:
        u, v = v, u
    p[u] += p[v]
    p[v] = u
    return True

res = []
for _ in range(n):
    parts = input().split()
    if parts[0] == 'I':
        union(int(parts[1]), int(parts[2]))
    else:
        res.append(-p[find(int(parts[1]))])

print("\n".join(map(str, res)))