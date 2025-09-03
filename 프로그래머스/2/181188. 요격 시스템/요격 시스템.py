def solution(targets):
    sorted_targets = sorted(targets, key=lambda seg: seg[1])
    current = -1
    res = 0
    for s, e in sorted_targets:
        if current <= s:
            current = e
            res += 1
    return res