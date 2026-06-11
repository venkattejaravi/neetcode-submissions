class Solution {
    public int trap(int[] height) {
        
        int l = 0;
        int r = height.length - 1;
        int maxArea;
        int units = 0;

        int leftMax = height[0];
        int rightMax = height[height.length - 1];

        while(l < r){
            if(leftMax < rightMax){
               l++;
               leftMax = Math.max(leftMax, height[l]);
               units += leftMax - height[l];
            } else {
                r--;
                rightMax = Math.max(rightMax, height[r]);
                units += rightMax - height[r];
            }
        }
        return units;
    }
}
