class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        hashSet = set()
        l, r = 0,0
        longest = 0

        while r < len(s):
            if s[r] not in hashSet:
                longest = max(longest, r - l + 1)
                hashSet.add(s[r])
                r += 1
            else:
                while s[r] in hashSet:
                    hashSet.remove(s[l])
                    l += 1

        return longest

        return longest