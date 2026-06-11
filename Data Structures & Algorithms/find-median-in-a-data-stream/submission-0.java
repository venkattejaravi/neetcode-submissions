class MedianFinder {
    private PriorityQueue<Integer> small;
    private PriorityQueue<Integer> large;

    public MedianFinder() {
        small = new PriorityQueue<>(Collections.reverseOrder());
        large = new PriorityQueue<>();    
    }
    
    public void addNum(int num) {
        small.offer(num);

        if(! small.isEmpty() && ! large.isEmpty() && small.peek() > large.peek()) {
            large.offer(small.poll());
        }

        if(small.size() > large.size() + 1) {
            large.offer(small.poll());
        }
        if(large.size() > small.size() + 1) {
            small.offer(large.poll());
        }
    }
    
    public double findMedian() {
        if(large.size() > small.size()) {
            return large.peek();
        }
        if(small.size() > large.size()) {
            return small.peek();
        }
        if(!small.isEmpty() && !large.isEmpty()) {
            return (double) (((double) small.peek() + (double) large.peek()) / 2);
        } else {
            return 0;
        }
    }
}
