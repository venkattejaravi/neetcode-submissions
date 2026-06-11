class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
         List<Integer> res = new ArrayList<>();
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Deque<Integer> q = new ArrayDeque<>();

        for(int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }

        for(int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int preReq = prerequisite[1];

            indegree[preReq]++;
            graph.get(course).add(preReq);
        }

        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) q.offer(i);
        }
        int finished = 0;

        while(! q.isEmpty()) {
            int course = q.poll();
            finished++;
            res.add(course);
            for(int preReq : graph.get(course)) {
                indegree[preReq]--;
                if(indegree[preReq] == 0) q.offer(preReq);
            }
        }

        if(finished == numCourses) {
            Collections.reverse(res);
            return res.stream().mapToInt(Integer::intValue).toArray();
        } else {
            return new int[]{};
        }
    }
}
