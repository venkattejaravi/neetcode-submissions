class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        //Construct adjList
        // Use HashMap with key as String and value as PriorityQueue<String>
        // MinHeap because we want the destinations to be lexically ordered
        Map<String, PriorityQueue<String>> adjList = new HashMap<>();
        for(List<String> ticket : tickets) {
            adjList.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).offer(ticket.get(1));
        }
        // take res as LinkedList
        LinkedList<String> res = new LinkedList<>();
        
        // call dfs("JFK", adjList, res)
        dfs("JFK", adjList, res);

        return res;
    }

    //Inside the dfs
    public void dfs(String src, Map<String, PriorityQueue<String>> adjList, LinkedList<String> res) {
        // get the neighbor destinations from adList of src
        PriorityQueue<String> destinations = adjList.get(src);

        // untill minHeap becomes null or Empty call dfs(minHeap.poll(), adjList, res)
        while(destinations != null && ! destinations.isEmpty()) {
            dfs(destinations.poll(), adjList, res);
        }

        // At the end of the dfs add the src to the left most of the linkedlist.
        res.addFirst(src);
    }
    
    
    
}
