class Solution:
    count = 0

    def dfs(self, grid, row, col):
        if row >= len(grid) or col >= len(grid[0]) or row < 0 or col <0:
            return

        if grid[row][col] != "1":
            return

        grid[row][col] = "0"
        self.dfs(grid, row, col -1)
        self.dfs(grid, row, col + 1)
        self.dfs(grid, row - 1, col)
        self.dfs(grid, row + 1, col)

    def numIslands(self, grid: List[List[str]]) -> int:
        self.count = 0
	
        for row in range(len(grid)):
            for col in range(len(grid[0])):
                if grid[row][col] == "1":
                    self.count += 1
                    grid[row][col] = "0"
                    self.dfs(grid, row, col -1)
                    self.dfs(grid, row, col + 1)
                    self.dfs(grid, row - 1, col)
                    self.dfs(grid, row + 1, col)
        return self.count

        