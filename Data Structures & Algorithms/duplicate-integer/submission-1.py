class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        dups = []
        for n in nums:
            if n in dups:
                return True
            else:
                dups.append(n)

        return False