class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(! wordList.contains(endWord)) return 0;
        
        // build graph
        Map<String, List<String>> adjList = new HashMap<>();
        wordList.add(beginWord);

        for(String word : wordList) {
            for(int j = 0; j < word.length(); j++) {
                String pattern = word.substring(0, j) + "*" + word.substring(j + 1, word.length());
                adjList.putIfAbsent(pattern, new ArrayList<>());
                adjList.get(pattern).add(word);
            } 
        }

        //BFS
        Set<String> visited = new HashSet<>();
        Deque<String> q = new ArrayDeque<>();
        int res = 1;

        visited.add(beginWord);
        q.offer(beginWord);

        while(! q.isEmpty()) {
            int qSize = q.size();

            for(int i = 0; i < qSize; i++) {
                String word = q.poll();

                if(word.equals(endWord)) return res;

                for(int j = 0; j < word.length(); j++) {
                    String pattern = word.substring(0, j) + "*" + word.substring(j + 1, word.length());
                    for(String neighbor : adjList.get(pattern)) {
                        if(!visited.contains(neighbor)) {
                            visited.add(neighbor);
                            q.offer(neighbor);
                        }

                    }
                }
            }
            res++;

        }
    return 0;

    }
}
