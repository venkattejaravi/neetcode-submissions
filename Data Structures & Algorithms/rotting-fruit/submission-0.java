class Solution {
    public int orangesRotting(int[][] grid) {
        Deque<int[]> q = new ArrayDeque<>();
        int minutes = 0;
        int fresh = 0;
        int m = grid.length;
        int n = grid[0].length;

        // add cells with rotten fruits to the queue first.
        for(int row = 0; row < m; row ++) {
            for(int col = 0; col < n; col ++) {
                if(grid[row][col] == 2) {
                    q.offer(new int[]{row, col, 0});
                } else if(grid[row][col] == 1) {
                    fresh++;
                }
            }
        }


        // Start multi-source BFS
        // Loop through the queue untill it becomes empty.
        // for every cell, make minutes = time of the current cell
        //check if it got any neighbors with fresh fruits.
        // if fresh fruits are found, then make them rotten -> 2
        // fresh--;
        // Add the row, col of the newly rotten fruit to the queue along with time + 1;
        // At the end if fresh == 0 we can return the minutes. else -1;

        // Start multi-source BFS
        // Loop through the queue untill it becomes empty.
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while(! q.isEmpty()) {
            int[] currCell = q.poll();
            int r = currCell[0], c = currCell[1], time = currCell[2];
            minutes = time;

            //check if it got any neighbors with fresh fruits.
            for(int[] dir : dirs) {
                int nr = r + dir[0], nc = c + dir[1];

            // if fresh fruits are found, then make them rotten -> 2
            if(nr >= 0 && nr < m && nc >=0 && nc < n && grid[nr][nc] == 1) {
                grid[nr][nc] = 2;
                fresh--;

                //Add the row, col of the newly rotten fruit to the queue along with time + 1;
                q.offer(new int[] {nr, nc, time + 1});
                
            }
            }


        }

        return fresh == 0 ? minutes: -1;

    }
}
