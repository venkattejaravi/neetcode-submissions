class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }

        for(int[] preReq : prerequisites) {
            graph.get(preReq[0]).add(preReq[1]);
        }

        for(int i = 0 ; i < numCourses; i++){
            if(! dfs(i, graph, new HashSet<>())) return false;
        }

        return true;

    }

    public boolean dfs(int course, Map<Integer, List<Integer>> graph, Set<Integer> visited) {
        if(graph.get(course).size() == 0) return true;
        if(visited.contains(course)) return false;

        visited.add(course);
        for(int preReq : graph.get(course)) {
            if(! dfs(preReq, graph, visited)) return false;
        }
        
        visited.remove(course);
        graph.put(course, new ArrayList<>());
        return true;
    }
}
