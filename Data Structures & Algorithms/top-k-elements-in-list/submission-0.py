class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        from collections import Counter
        import heapq

        num_freq = Counter(nums)
        min_heap = []

        for num, freq in num_freq.items():
            heapq.heappush(min_heap, (freq, num))
            if len(min_heap) > k:
                heapq.heappop(min_heap)

        return [num for freq, num in min_heap]
        

        