class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freq = new HashMap<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        Deque<int[]> q = new ArrayDeque<>();
        int time = 0;

        for(char task : tasks) freq.put(task, freq.getOrDefault(task, 0) + 1);

        for(int value : freq.values()) maxHeap.add(value);

        // iterate through the maxHeap and q while either of them or not empty
        // meanwhile processing the tasks.
        while((! maxHeap.isEmpty()) || (! q.isEmpty())) {
            time++;
            if(! maxHeap.isEmpty()) {
                int cnt = maxHeap.poll() - 1;
                if(cnt > 0) {
                    q.addLast(new int[]{cnt, time + n});
                }
            }

            // We have to pull the task from the q only when the task time has come.
            if(! q.isEmpty()) {
                if(q.getFirst()[1] == time) {
                    maxHeap.add(q.removeFirst()[0]);
                }
            }
        }
        return time;




    }
}
