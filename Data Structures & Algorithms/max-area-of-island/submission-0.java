class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        for(int r = 0; r < grid.length; r++) {
            for(int c = 0; c < grid[0].length; c++) {
                if(grid[r][c] == 1) {
                    maxArea = Math.max(maxArea, dfs(r, c, grid));
                }
            }    
        }
        return maxArea;
    }

    public int dfs(int r, int c, int[][] grid) {
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] != 1) return 0;

        grid[r][c] = -1;

        return 1 + dfs(r, c + 1, grid) + dfs(r, c - 1, grid) + dfs(r - 1, c, grid) + dfs(r + 1, c, grid);
    }
}
