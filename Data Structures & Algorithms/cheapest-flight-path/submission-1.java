class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int[][] dist = new int[n][k + 2];
        for(int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE); 

        for(int[] flight : flights) {
            graph.computeIfAbsent(flight[0], m -> new ArrayList<>()).add(new int[]{flight[1], flight[2]});
        }

        minHeap.offer(new int[]{0, src, 0});
        dist[src][0] = 0;

        while(! minHeap.isEmpty()) {
            int[] pair = minHeap.poll();
            int cost = pair[0], city = pair[1], stops = pair[2];

            if(city == dst) return cost;

            if(stops > k) continue;

            if(graph.containsKey(city)) {
                for(int[] neigh : graph.get(city)) {
                int price = neigh[1], next = neigh[0];
                int newCost = price + cost;
                if(newCost < dist[next][stops + 1]) {
                    dist[next][stops + 1] = newCost;
                    minHeap.offer(new int[]{newCost, next, stops + 1});
                }
            }
            }
            
        }

        return -1;
    }
}
