def solution(diffs, times, limit):
    
    def is_valid(target: int) -> bool:
        count = 0
        for i in range(len(diffs)):
            if diffs[i] <= target:
                count += times[i]
            else:
                count += (times[i - 1] + times[i]) * (diffs[i] - target) + times[i]
            if count > limit:
                return False
        return True
    
    start, end = 1, 100000
    while start < end:
        mid = (start + end) // 2
        if is_valid(mid):
            end = mid
        else:
            start = mid + 1
    
    return start
