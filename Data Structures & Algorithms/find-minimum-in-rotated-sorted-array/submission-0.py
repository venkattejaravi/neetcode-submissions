class Solution:
    def findMin(self, nums: List[int]) -> int:
        l = 0
        r = len(nums) - 1
        res = nums[l]
        while l <= r:
            if nums[l] <= nums[r]:
                res = min(res, nums[l])
                break
            # Check which partition we are in

            mid = (l + r) // 2
            res = min(res, nums[mid])
            if nums[mid] >= nums[l]:
                # We are in left portion
                l = mid + 1
            else:
                # We are in right portion
                r = mid - 1

        return res