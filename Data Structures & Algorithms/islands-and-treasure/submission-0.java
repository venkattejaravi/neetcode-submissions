class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Deque<int[]> q = new ArrayDeque<>();
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; 

        int m = grid.length;
        int n = grid[0].length;

        for(int row = 0 ; row < m; row ++) {
            for(int col = 0; col < n; col ++) {
                if(grid[row][col] == 0) {
                    q.offer(new int[]{row, col});
                }
            }
        }
        float INF = 2147483647;

        while(! q.isEmpty()) {
            int[] cell = q.poll();
            int r = cell[0];
            int c = cell[1];

            for(int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c+ dir[1];

                // check bounds
                if(nr < 0 || nr >= m || nc < 0 || nc >= n || grid[nr][nc] != INF) continue;

                if(grid[nr][nc] == INF) {
                    grid[nr][nc] = grid[r][c] + 1;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
    }
}
