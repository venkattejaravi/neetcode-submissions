class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        freq = {}
        for n in nums:
            freq[n] = freq.get(n, 0) + 1
        
        import heapq
        heap = []
        for n, f in freq.items():
            heapq.heappush(heap, (f, n))
            if (len(heap) > k):
                heapq.heappop(heap)                    
        result = []
        while(k > 0):
            result.append(heapq.heappop(heap)[1])
            k -= 1

        return result
        

        

