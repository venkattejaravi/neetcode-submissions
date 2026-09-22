class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        import heapq
        from collections import Counter
        min_heap = []

        counter = Counter(nums)
        
        for num, freq in counter.items():
            heapq.heappush(min_heap, (freq, num))
            if len(min_heap) > k:
                heapq.heappop(min_heap)

        result = []
        for _ in range(k):
            result.append(heapq.heappop(min_heap)[1])
        return result

