class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        '''
        nums = [1, 2, 4, 6]
        prefix = [1, 1, 2, 8]
        postfix = [48, 24, 6, 1]
        res = [48, 24, 12, 8]
        '''
        res = [1] * len(nums)

        # calculate prefix
        prefix = 1
        for i in range(len(res)):
            res[i] = prefix
            prefix *= nums[i]


        # calculate postfix
        postfix = 1
        for i in range(len(res) - 1, -1, -1):
            res[i] *= postfix
            postfix *= nums[i]

        return res