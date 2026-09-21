class Solution:
    
        from collections import deque


        def orangesRotting(self, grid: List[List[int]]) -> int:
            minutes = 0
            fresh_count = 0
            rows, cols = len(grid), len(grid[0])
            
            q = deque()
            
            for r in range(rows):
                for c in range(cols):
                    if(grid[r][c] == 1):
                        fresh_count += 1
                    elif grid[r][c] == 2:
                        q.append((r, c))



            directions = [(0, 1), (0, -1), (1, 0), (-1, 0)]

            while q and fresh_count > 0:
                minutes += 1

                for _ in range(len(q)):
                    curr_r, curr_c = q.popleft()

                    for r, c in directions:
                        dr, dc = curr_r - r, curr_c - c

                        if 0 <= dr < rows and 0 <= dc < cols and grid[dr][dc] == 1:
                            fresh_count -= 1
                            grid[dr][dc] = 2
                            q.append((dr, dc))
                
            return -1 if fresh_count > 0  else minutes
