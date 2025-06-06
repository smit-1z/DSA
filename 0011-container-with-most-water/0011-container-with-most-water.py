class Solution:
    def maxArea(self, height: List[int]) -> int:
        maxWater = 0
        i, j = 0, len(height) - 1

        while i < j:
            area = (j - i) * min(height[i], height[j])
            maxWater = max(maxWater, area)
            if height[i] > height[j]:
                j -= 1
            else:
                i += 1
        return maxWater