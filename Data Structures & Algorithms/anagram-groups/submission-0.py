class Solution:
    from collections import defaultdict
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        res = defaultdict(list)
        '''
        act = a = 1, c = 1, t = 1
        (1, 1, 1) = ["act", "cat"]  
        '''
        for str in strs:
            count = [0] * 26
            for c in str:
                count[ord(c) - ord('a')] += 1

            res[tuple(count)].append(str)

        return res.values() 
