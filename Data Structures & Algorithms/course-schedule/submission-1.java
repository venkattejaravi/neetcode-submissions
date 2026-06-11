class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Deque<Integer> q = new ArrayDeque<>();
        int[] indegree = new int[numCourses];
        int finished = 0;

        for(int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }

        for(int[] preReq : prerequisites) {
            indegree[preReq[1]]++;
            graph.get(preReq[0]).add(preReq[1]);
        }

        for(int course = 0 ; course < numCourses; course++){
            if(indegree[course] == 0) {
                q.offer(course);
            }
        }

        while(! q.isEmpty()) {
            int course = q.poll();
            finished++;
            for(int preReq : graph.get(course)) {
                indegree[preReq]--;
                if(indegree[preReq] == 0) {
                    q.offer(preReq);
                }
            }
        }

        return finished == numCourses;

    }
}
