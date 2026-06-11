class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        if(heights.length == 0 || heights[0].length == 0) return res;
        int m = heights.length;
        int n = heights[0].length;
    
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // run pacific (Top row & left most col)
        for(int c = 0; c < n; c++) dfs(0, c, pacific, heights);
        for(int r = 0; r < m; r++) dfs(r, 0, pacific, heights);

        // run atlantic (bottom row & right most col)
        for(int c = 0; c < n; c++) dfs(m - 1, c, atlantic, heights);
        for(int r = 0; r < m; r++) dfs(r, n - 1, atlantic, heights);

        for(int r = 0; r < m; r ++) {
            for(int c = 0; c < n; c++) {
                if(pacific[r][c] && atlantic[r][c]) {
                    res.add(Arrays.asList(r, c));
                }    
            }
        } 

        return res;

    } 

    public void dfs(int r, int c, boolean[][] visited, int[][] heights) {
        if(visited[r][c]) return;

        visited[r][c] = true;
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for(int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            if(nr < 0 || nr >= heights.length || nc < 0 || nc >= heights[0].length) continue;
            if(heights[nr][nc] < heights[r][c]) continue;
            dfs(nr, nc, visited, heights);
        }

    }
}
