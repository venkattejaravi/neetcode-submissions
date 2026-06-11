class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length - 1;
        int maxWater = Integer.MIN_VALUE;
        int area;
        while(l < r){
            if(heights[l] <= heights[r]) {
                area = heights[l] * (r - l);
                l++;
            } else {
                area = heights[r] * (r - l);
                r--;
            }
            maxWater = Math.max(maxWater, area);
        }
        return maxWater;
    }
}
