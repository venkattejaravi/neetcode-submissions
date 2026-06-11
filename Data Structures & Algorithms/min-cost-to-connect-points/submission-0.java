class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        Map<Integer, List<int[]>> adjList = new HashMap<>();

        for(int i = 0; i < n; i++) {
            int x1 = points[i][0], y1 = points[i][1];
            adjList.putIfAbsent(i, new ArrayList<>());
            for(int j = i + 1; j < n; j++) {
                int x2 = points[j][0], y2 = points[j][1];
                int val = Math.abs(x2 - x1) + Math.abs(y2 - y1);
                adjList.putIfAbsent(j, new ArrayList<>());
                adjList.get(i).add(new int[]{val, j});
                adjList.get(j).add(new int[]{val, i});
            }
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        Set<Integer> visited = new HashSet<>();
        int minCost = 0;
        minHeap.offer(new int[]{0, 0});

        while(visited.size() < n) {
            int[] pair = minHeap.poll();
            int cost = pair[0], node = pair[1];
            if(visited.contains(node)) continue;
            visited.add(node);
            minCost += cost;

            for(int[] neighbor : adjList.get(node)) {
                int neighborCost = neighbor[0], neighborNode = neighbor[1];
                if(! visited.contains(neighborNode)) minHeap.offer(new int[]{neighborCost, neighborNode});
            }
        }

        return minCost;
    }
}
