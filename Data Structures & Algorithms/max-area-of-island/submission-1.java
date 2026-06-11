class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Deque<int[]> q = new ArrayDeque<>();
        int rSize = grid.length, cSize = grid[0].length;

        for(int row = 0; row < rSize; row++) {
            for(int col = 0; col < cSize; col++) {
                if(grid[row][col] == 1) {
                    
                    q.offer(new int[]{row, col});
                    grid[row][col] = -1;

                    int area = 0;

                    while(! q.isEmpty()) {
                        int[] cell = q.poll();
                        int r = cell[0], c = cell[1];
                        area++;
                        for(int[] dir : dirs) {
                            int newR = r + dir[0], newC = c + dir[1];
                            
                            if(newR >= 0 && newC >= 0 && newR < rSize && newC < cSize && grid[newR][newC] == 1) {
                                q.offer(new int[]{newR, newC});
                                grid[newR][newC] = -1;
                            }


                        }
                    }
                    maxArea = Math.max(maxArea, area);

                }
            }    
        }
        return maxArea;
    }
}
