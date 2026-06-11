class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        l, r = 0, 0
        charFreq = {}
        maxFreq = 0
        longest = 0

        while r < len(s):
            charFreq[s[r]] = 1 + charFreq.get(s[r], 0)
            maxFreq = max(maxFreq, charFreq[s[r]])
            while r - l + 1 - maxFreq > k:
                if charFreq[s[l]]: 
                    charFreq[s[l]] -= 1
                l += 1
            longest = max(longest, r - l + 1)
            r += 1
        return longest


            