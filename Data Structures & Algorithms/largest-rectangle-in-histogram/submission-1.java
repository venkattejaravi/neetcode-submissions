class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();
        int maxArea = 0;

        for(int i = 0; i < heights.length; i++){
            int start = i;
            while(!stack.isEmpty() && stack.peek()[1] > heights[i]){
                int index = stack.peek()[0];
                int height = stack.peek()[1];
                maxArea = Math.max(maxArea, height * (i - index));
                stack.pop();
                start = index;
            }
            stack.push(new int[]{start, heights[i]});
        }

        for(int[] pair: stack){
            int index = pair[0];
            int height = pair[1];
            maxArea = Math.max(maxArea, height * (heights.length - index));
        }
        return maxArea;
    }
}
