class Solution {
    public int countComponents(int n, int[][] edges) {
        int count = 0;
        Set<Integer> visited = new HashSet<>();
        
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());    
        }

        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

         for(int i = 0; i < n; i++) {
            if(! visited.contains(i)) {
                dfs(i, - 1, graph, visited);
                count++;
            } 
        }
        return count;
    }

    public void dfs(int node, int parent, Map<Integer, List<Integer>> graph, Set<Integer> visited) {
        if(visited.contains(node)) return;
        visited.add(node);
        for(int neigh : graph.get(node)) {
            if(neigh == parent) continue;
            dfs(neigh, node, graph, visited);
        }
    }
}
