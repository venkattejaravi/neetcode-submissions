class Solution {
    public int numIslands(char[][] grid) {
        int numOfIslands = 0;
        int rowSize = grid.length, colSize = grid[0].length;
        Deque<int[]> q = new ArrayDeque<>();
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for(int row = 0; row < rowSize; row ++) {
            for(int col = 0; col < colSize; col ++) {
                if(grid[row][col] == '1') {
                    numOfIslands++;
                    
                    //mark the cell as visited
                    grid[row][col] = '#';
                    q.offer(new int[]{row, col});

                    while(! q.isEmpty()) {
                        int[] cell = q.poll();
                        int r = cell[0], c = cell[1];

                        for(int[] dir : dirs) {
                            int newR = r + dir[0], newC = c + dir[1];
                            if(newR >= 0 && newR < rowSize && newC >= 0 && newC < colSize && grid[newR][newC] == '1') {
                                //mark the cell as visited
                                grid[newR][newC] = '#';
                                q.offer(new int[]{newR, newC});
                            }    
                        }    
                    }


                }
                
            }
        }
        return numOfIslands; 
    }

    
}
