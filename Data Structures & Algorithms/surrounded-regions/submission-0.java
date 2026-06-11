class Solution {
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        if(m == 0 || n == 0) return;
        
        Deque<int[]> q = new ArrayDeque<>();
        
        for(int row = 0; row < m ; row ++) {
            // left border
            if(board[row][0] == 'O'){
                board[row][0] = '#';
                q.offer(new int[]{row, 0});
            } 
            // Right border
            if(board[row][n - 1] == 'O'){
                board[row][n - 1] = '#';
                q.offer(new int[]{row, n - 1});
            } 
        }

        for(int col = 0; col < n ; col ++) {
            // Top border
            if(board[0][col] == 'O'){
                board[0][col] = '#';
                q.offer(new int[]{0, col});
            }
            // Bottom border
            if(board[m - 1][col] == 'O') {
                board[m - 1][col] = '#';
                q.offer(new int[]{m - 1, col});
            } 
        }

        bfs(q, board);

        for(int r = 0; r < m; r++) {
            for(int c = 0; c < n; c++) {
                if(board[r][c] == 'O') board[r][c] = 'X';
                else if(board[r][c] == '#') board[r][c] = 'O';
            }
        }       
    }

    public void bfs(Deque<int[]> q, char[][] board) {
        int m = board.length, n = board[0].length;
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while(! q.isEmpty()) {
            int[] cell = q.poll();
            int r = cell[0], c = cell[1];

            for(int[] dir : dirs) {
                int nr = r + dir[0], nc = c + dir[1];
                if(nr < 0 || nr >= m || nc < 0 || nc >= n || board[nr][nc] != 'O') continue;
                board[nr][nc] = '#';
                q.offer(new int[]{nr, nc});
            } 
        }
    }
}
