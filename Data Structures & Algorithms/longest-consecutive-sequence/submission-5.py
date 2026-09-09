class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        longest = 0
        numSet = set(nums)

        for i in range(len(nums)):
            if(nums[i] - 1 in numSet):
                continue
            length = 1
            while (nums[i] + length in numSet):
                length += 1
            if(length > longest):
                longest = length
        return longest