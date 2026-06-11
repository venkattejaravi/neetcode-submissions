class Solution {
    public int longestConsecutive(int[] nums) {
        // we need to find the start of the sequence.
        // we can check for predecessor of a given number. if it is there then just skip the number.
        // if it is not there then we can say that it is start of the sequence.
        // calculate the length of the sequence by increasing the local variable length by 1 if 
        // the successor of the number is found.
        // At the end of the sequence longest = max(longest, length)
        // return longest
        if(nums.length == 0) return 0;
        int i = 0;
        int longest = Integer.MIN_VALUE;
        int j;  
        int length;

        Set<Integer> set = new HashSet<>();

        for(int n : nums){
            set.add(n);
        }

        while(i < nums.length){
            
            j = i;
            if(!set.contains(nums[j] - 1)){
                length = 0;
                while(set.contains(nums[j] + length)){
                    length++;
                }
                longest = Math.max(longest, length);
            }
            i++;
        }
        return longest;
    }
}
