class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // construct graph
        Map<Integer, List<int[]>> graph = new HashMap<>();

        for(int i = 1; i <= n; i ++) {
            graph.putIfAbsent(i, new ArrayList<>());
        }

        for(int[] time : times) {
            int u = time[0], v = time[1], t = time[2];
            graph.get(u).add(new int[]{v, t});
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        Set<Integer> visited = new HashSet<>();
        int minTime = 0;

        minHeap.add(new int[]{k, 0});

        while(! minHeap.isEmpty()) {
            int[] pair = minHeap.poll();
            int node = pair[0], wait = pair[1];
            if(visited.contains(node)) continue;

            minTime = Math.max(minTime, wait);

            visited.add(node);

            for(int[] neighbor : graph.get(node)) {
                int n1 = neighbor[0], w1 = neighbor[1];
                if(! visited.contains(n1)) {
                    minHeap.add(new int[]{n1, wait + w1});
                }
            }
        }
        return visited.size() == n ? minTime : -1;
    }
}
