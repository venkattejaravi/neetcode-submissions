class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        from collections import deque

        count = 0
        for row in range(len(grid)):		
            for col in range(len(grid[0])):
                if(grid[row][col]) == "1":
                    count += 1
                    
                    q = deque()
                    q.append((row, col))

                    while q:
                        curr_row, curr_col = q.popleft()
                        if curr_row >= 0 and curr_col >= 0 and curr_row < len(grid) and curr_col < len(grid[0]) and grid[curr_row][curr_col] == "1":
                           
                            grid[curr_row][curr_col] = "*"

                            q.append((curr_row, curr_col + 1))
                            q.append((curr_row, curr_col - 1))
                            q.append((curr_row -1, curr_col))
                            q.append((curr_row + 1, curr_col))


        return count
