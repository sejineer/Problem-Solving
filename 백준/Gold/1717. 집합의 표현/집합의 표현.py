import sys
input = sys.stdin.readline

def find(x: int) -> int:
    if p[x] < 0:
        return x
    p[x] = find(p[x])
    return p[x]

def union(u: int, v: int) -> bool:
    u, v = find(u), find(v)
    if u == v:
        return False
    if p[u] > p[v]:
        u, v = v, u
    if p[u] == p[v]:
        p[u] -= 1
    p[v] = u
    return True

n, m = map(int, input().split())
p = [-1] * (n + 1)

out = []
for _ in range(m):
    t, a, b = map(int, input().split())
    if t == 0:
        union(a, b)
    else:
        out.append("YES" if find(a) == find(b) else "NO")

print("\n".join(out))