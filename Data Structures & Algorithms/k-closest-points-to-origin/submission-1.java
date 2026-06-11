class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<double []> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        int[][] res = new int[k][2];

        for(int i = 0; i < points.length; i++) {
            double distance = Math.sqrt(points[i][0] * points[i][0] + points[i][1] * points[i][1]);
            maxHeap.add(new double[]{distance, (double) i});

            if(maxHeap.size() > k) maxHeap.poll();        
        } 
        int index = 0;
        while(! maxHeap.isEmpty()) {
            res[index++] = points[(int) maxHeap.poll()[1]];
        }

        return res;        

    }
}
