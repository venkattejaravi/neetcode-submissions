class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if not len(s):
	        return 0


        left = 0
        right = 0
        longest = 0
        seen = set()
        
        while (left < len(s) and  right < len(s)):
            while(s[right] in seen and left < len(s)):
                seen.remove(s[left])
                left += 1
            longest = max(longest, right - left + 1)
            seen.add(s[right])
            right += 1

        return longest
