class Solution:
    def maxArea(self, heights: List[int]) -> int:
        max_amount = 0

        left = 0
        right = len(heights) - 1
        while (left < right):
            if(heights[left] <= heights[right]):
                length = heights[left]
            else:
                length = heights[right]

            amount = length * (right - left)
            max_amount = max(max_amount , amount)
            
            if (heights[left] < heights[right]):
                left += 1
            else:
                right -= 1

        return max_amount
