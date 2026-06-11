class Solution {
    public int countComponents(int n, int[][] edges) {
        int count = 0;
        Set<Integer> visited = new HashSet<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Deque<int[]> q = new ArrayDeque<>();

        for(int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());    
        }

        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        for(int i = 0; i < n; i++) {
            if(! visited.contains(i)) {
                visited.add(i);
                q.offer(new int[]{i, -1});
                while(! q.isEmpty()) {
                    int[] currNode = q.poll();
                    int node = currNode[0], parent = currNode[1];

                    for(int neigh : graph.get(node)) {
                        if(visited.contains(neigh) || neigh == parent) continue;
                        visited.add(neigh);
                        q.offer(new int[] {neigh, node});
                    }

                }
                count++;
            } 
        }

        return count;
    }

}
