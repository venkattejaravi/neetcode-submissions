class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();

        for(String word : words) {
            for(char c : word.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
                inDegree.putIfAbsent(c, 0);
            }
        }

        for(int i = 0; i < words.length - 1; i++) {
            String w1 = words[i], w2 = words[i + 1];
            if(w1.length() > w2.length() && w1.startsWith(w2)) return "";

            for(int j = 0; j < Math.min(w1.length(), w2.length()); j++) {
                char c1 = w1.charAt(j), c2 = w2.charAt(j);
                if(c1 != c2) {
                    if(! graph.get(c1).contains(c2)) {
                        graph.get(c1).add(c2);
                        inDegree.put(c2, inDegree.get(c2) + 1);
                    }
                    break;
                }
            }
        }

        Deque<Character> q = new ArrayDeque<>();

        for(Map.Entry<Character, Integer> entry : inDegree.entrySet()) {
            if(entry.getValue() == 0) q.offer(entry.getKey());
        }

        String res = "";

        while(! q.isEmpty()) {
            char c = q.poll();
            res += c;

            for(char nei : graph.get(c)) {
                inDegree.put(nei, inDegree.get(nei) - 1);
                if(inDegree.get(nei) == 0) q.offer(nei);
            }

        }
        

        return res.length() == inDegree.size() ? res : "";

    }
}
