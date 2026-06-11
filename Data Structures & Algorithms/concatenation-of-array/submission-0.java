class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] res = new int[2 * n];
        int i = 0;
        while(i < n) {
            res[i] = nums[i];
            res[i + n] = nums[i++]; 
        }
        return res; 
    }
}