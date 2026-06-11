class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<int[]> q = new ArrayDeque<>();

        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // Add the pacific side cells to the queue first.
        for(int col = 0; col < n; col ++) {
            pacific[0][col] = true;
            q.offer(new int[]{0, col});
        }
        for(int row = 0; row < m; row ++) {
            pacific[row][0] = true;
            q.offer(new int[]{row, 0});
        }
        bfs(q, pacific, heights);

        // Add the atlantic side cells to the queue
        for(int row = 0; row < m; row ++) {
            atlantic[row][n - 1] = true;
            q.offer(new int[]{row, n - 1});
        }
        for(int col = 0; col < n; col ++) {
            atlantic[m - 1][col] = true;
            q.offer(new int[]{m - 1, col});
        }
        bfs(q, atlantic, heights);

        for(int row = 0; row < m; row ++) {
            for(int col = 0; col < n; col ++) {
                if(pacific[row][col] && atlantic[row][col]) {
                    res.add(Arrays.asList(row, col));
                }
            }
        }
        return res;
        
    }

    public void bfs(Deque<int[]> q, boolean[][] visited, int[][] heights) {
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while(! q.isEmpty()) {
            int[] cell = q.poll();
            int r = cell[0], c = cell[1];

            for(int[] dir : dirs) {
                int nr = r + dir[0], nc = c + dir[1];
                if(nr >= 0 && nr < heights.length && nc >= 0 && nc < heights[0].length && heights[nr][nc] >= heights[r][c]) {
                    if(visited[nr][nc]) continue;
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }    
            }

        }
    }
}
