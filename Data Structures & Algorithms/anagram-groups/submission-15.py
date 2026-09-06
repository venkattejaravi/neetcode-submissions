class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        result = defaultdict(list)
        for s in strs:
            index_freq = [0] * 26
            for c in s:
                index_freq[ord(c) - ord('a')] +=1
            result[tuple(index_freq)].append(s)
            
        return list(result.values())
