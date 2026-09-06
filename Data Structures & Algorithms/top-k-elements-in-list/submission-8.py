class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        freq = {}
        for n in nums:
            freq[n] = freq.get(n, 0) + 1
        
        freq_counter = defaultdict(list)

        for n, freq in freq.items():
            freq_counter[freq].append(n)

        freq_counter = dict(sorted(freq_counter.items(), reverse = True))
        
        result = []
        for freq, values in freq_counter.items():
            for val in values:
                result.append(val)
                k -= 1
                if(k==0):
                    return result

        return result
        

        

