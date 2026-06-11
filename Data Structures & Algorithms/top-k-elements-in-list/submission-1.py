class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        '''
        {
            1 : 1,
            2 : 2,
            3 : 3
        }
        
        [[], [1], [2], [3], [], [], []]
        [3, 2]
        '''
        counter = {}
        for num in nums:
            counter[num] = counter.get(num, 0) + 1
        freq = [[] for i in range(len(nums) + 1)]
        
        for n, c in counter.items():
            freq[c].append(n)
        
        res = []
        for i in range(len(freq) - 1, -1 , -1):
            for n in freq[i]:
                res.append(n)
                if len(res) == k:
                    return res

        return res
