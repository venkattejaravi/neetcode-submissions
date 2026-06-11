class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False

        counterArray = [0] * 26

        for i in range(len(s)):
            counterArray[ord(s[i]) - ord('a')] += 1
            counterArray[ord(t[i]) - ord('a')] -= 1

        for num in counterArray:
            if num != 0:
                return False

        return True