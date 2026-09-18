class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        max_length = 0
        left = 0
        right = 0
        freq = defaultdict(int)

        while(left < len(s) and right < len(s)):
            freq[s[right]] += 1
            
            while (right - left + 1) - max(freq.values(), default = 0) > k:
                freq[s[left]] -= 1
                left += 1
            max_length = max(max_length, right - left + 1)
            right += 1
            
        return max_length
