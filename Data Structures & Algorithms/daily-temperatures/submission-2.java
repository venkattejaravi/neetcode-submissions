class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<int[]> monStack = new Stack<>();

        for(int i = 0; i < temperatures.length; i++){
            while(!monStack.isEmpty() && monStack.peek()[1] < temperatures[i]){
                res[monStack.peek()[0]] = i - monStack.peek()[0];
                monStack.pop();
            }
            monStack.push(new int[]{i, temperatures[i]});
        }
        return res;
    }
}
