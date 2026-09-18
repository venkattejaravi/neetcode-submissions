class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        from collections import Counter

        s1Counter = Counter(s1)


        for left in range(0, len(s2) - len(s1) + 1 ):
            if(Counter(s2[left : left + len(s1)]) == s1Counter):
                return True


        return False
