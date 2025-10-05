import sys
input = sys.stdin.readline

n, m = map(int, input().split())
p = [-1] * n

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
    if p[u] == p[v]:
        p[u] -= 1
    p[v] = u
    return True

for i in range(m):
    a, b = map(int, input().split())
    if not union(a, b):
        print(i + 1)
        sys.exit(0)

print(0)