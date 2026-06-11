class Solution {
    public int longestConsecutive(int[] nums) {
        int longest = 0;
        int length;
        int i = 0;
        int curr;
        HashSet<Integer> set = new HashSet<>();

        for(int n : nums){
            set.add(n);
        }
        
        while(i < nums.length){
            curr = nums[i];
            length = 0;
            if(!set.contains(curr - 1)) {
                while(set.contains(curr + length)){
                   length += 1; 
                }
                longest = Math.max(longest, length);
            }
            
            i += 1;
            
        }
        return longest;
    }
}
