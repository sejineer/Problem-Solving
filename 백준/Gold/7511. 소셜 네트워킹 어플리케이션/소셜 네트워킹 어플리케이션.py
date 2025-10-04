import sys
input = sys.stdin.readline

def find(x: int, p: list) -> int:
    if p[x] < 0:
        return x
    p[x] = find(p[x], p)
    return p[x]

def union(u: int, v: int, p: list) -> bool:
    u = find(u, p)
    v = find(v, p)
    if u == v:
        return False
    if p[u] > p[v]:
        u, v = v, u
    if p[u] == p[v]:
        p[u] -= 1
    p[v] = u
    return True

count = int(input())
res = []

for i in range(count):
    res.append(f"Scenario {i + 1}:")
    n = int(input())
    k = int(input())
    p = [-1] * n
    for _ in range(k):
        a, b = map(int, input().split())
        union(a, b, p)
    m = int(input())
    for _ in range(m):
        u, v = map(int, input().split())
        res.append("1" if find(u, p) == find(v, p) else "0")
    res.append("")

print("\n".join(res))