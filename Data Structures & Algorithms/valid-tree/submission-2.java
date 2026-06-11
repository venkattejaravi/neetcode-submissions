class Solution {
    public boolean validTree(int n, int[][] edges) {
        
        if(edges.length < n - 1) return false;

        // construct adjList 
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        Set<Integer> visited = new HashSet<>();

        Deque<int[]> q = new ArrayDeque<>();

        visited.add(0);
        q.offer(new int[]{0, -1});

        while(! q.isEmpty()) {
            int[] pair = q.poll();
            int node = pair[0];
            int parent = pair[1];

            for(int neigh : graph.get(node)) {
                if(neigh == parent) continue;
                if(visited.contains(neigh)) return false;
                visited.add(neigh);
                q.offer(new int[]{neigh, node});
            }

        }

        return visited.size() == n;

    }
}
