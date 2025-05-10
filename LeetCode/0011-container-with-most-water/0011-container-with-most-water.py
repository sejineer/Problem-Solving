class Solution:
    def maxArea(self, height: List[int]) -> int:
        result = 0
        start, end = 0, len(height) - 1

        while start < end:
            area = (end - start) * min(height[start], height[end])
            result = max(result, area)
            if height[start] < height[end]:
                start += 1
            else:
                end -= 1
        return result
