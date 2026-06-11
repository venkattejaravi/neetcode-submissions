class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False

        sCount, tCount = {}, {}

        for c in s:
            sCount[c] = sCount.get(c, 0) + 1

        for c in t:
            tCount[c] = tCount.get(c, 0) + 1

        for c in sCount.keys():
            if c not in tCount.keys() or sCount[c] != tCount[c]:
                return False
        return True 