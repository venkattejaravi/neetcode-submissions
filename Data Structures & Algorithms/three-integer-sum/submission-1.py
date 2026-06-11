class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        res = []
        nums.sort()

        for i, num in enumerate(nums):
            if i > 0 and nums[i - 1] == num:
                continue

            j = i + 1
            k = len(nums) - 1

            while j < k:
                _sum = nums[i] + nums[j] + nums[k]
                if _sum > 0:
                    k -= 1
                elif _sum < 0:
                    j += 1
                else:
                    res.append([nums[i], nums[j], nums[k]])
                    j += 1
                    while nums[j] == nums[j-1] and j < k:
                        j += 1

        return res
            
