class KthLargest {
    public int k;
    public PriorityQueue<Integer> minHeap;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();

        if(nums.length > 0) {
            for(int num: nums) {
                minHeap.add(num);
            }

            while(minHeap.size() > k) minHeap.poll();
        }    
    }
    
    public int add(int val) {
        minHeap.add(val);

        if(minHeap.size() > k) minHeap.poll();

        return minHeap.peek();
    }
}
