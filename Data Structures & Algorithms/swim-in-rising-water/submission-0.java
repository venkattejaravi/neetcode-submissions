class Solution {
    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        Set<List<Integer>> visited = new HashSet<>();
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        int m = grid.length, n = grid[0].length;

        minHeap.offer(new int[]{grid[0][0], 0, 0});

        while(minHeap != null && ! minHeap.isEmpty()) {
            int[] pair = minHeap.poll();
            int node = pair[0], r = pair[1], c = pair[2];

            if(visited.contains(Arrays.asList(r, c))) continue;
            if(r == m - 1 && c == n - 1) return node;
            
            visited.add(Arrays.asList(r, c));

            for(int[] dir : dirs) {
                int nr = r + dir[0], nc = c + dir[1];
                if(nr >= 0 && nr < m && nc >= 0 && nc < n && ! visited.contains(Arrays.asList(nr, nc))) {
                    minHeap.offer(new int[]{Math.max(node, grid[nr][nc]), nr, nc});
                }
            }

        }

        return -1;

    }
}
