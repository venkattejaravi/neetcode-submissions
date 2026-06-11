class Solution {
    public int[] productExceptSelf(int[] nums) {
        // Prefix * Postfix
        int[] res = new int[nums.length];
        
        //calculate prefix
        int prefix = 1;
        for(int i = 0; i < nums.length; i++){
            res[i] = prefix;
            prefix = prefix * nums[i];
        }

        //calculate postfix
        int postfix = 1;
        for(int i = nums.length - 1; i >= 0; i--){
            res[i] = res[i] * postfix;
            postfix = postfix * nums[i];
        }
        return res;
    }
}  
