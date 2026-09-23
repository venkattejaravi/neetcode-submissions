class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        import heapq
        from collections import deque

        count = Counter(tasks)
        max_heap = [freq for freq in count.values()]
        heapq.heapify_max(max_heap)

        time = 0

        q = deque()


        while max_heap or q:
            time += 1

            if max_heap:
                cnt = heapq.heappop_max(max_heap)
                cnt -= 1

                if(cnt > 0):
                    q.append([cnt, time + n]) 

            if q and q[0][1] == time:
                heapq.heappush_max(max_heap, q.popleft()[0])


        return time
