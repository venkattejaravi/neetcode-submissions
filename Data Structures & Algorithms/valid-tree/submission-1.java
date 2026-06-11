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

        // DFS into the graph
        
        if(hasCycle(0, -1, graph, visited)) return false;
        
        return visited.size() == n;

    }

    public boolean hasCycle(int node, int parent, Map<Integer, List<Integer>> graph, Set<Integer> visited) {
        if(visited.contains(node)) {
            // there is cycle
            return true;
        }
        visited.add(node);
        
        for(int neighbor : graph.get(node)) {
            if(neighbor == parent) continue;
            if(hasCycle(neighbor, node, graph, visited)) return true;
        }

        return false;
    }
}
