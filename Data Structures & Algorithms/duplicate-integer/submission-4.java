class Solution {
    public boolean hasDuplicate(int[] nums) {
        // Brute force
        // for(int i = 0; i < nums.length - 1; i++ ){
        //     for(int j = i + 1; j < nums.length; j++ ) {
        //         if(nums[i] == nums[j])
        //             return true;
        //     }
        // }
        // return false;

        // Sorting technique
        // Arrays.sort(nums);
        // for(int i = 0; i < nums.length - 1; i++){
        //     if(nums[i] == nums[i + 1]) {
        //         return true;
        //     }
        // }
        // return false;

        //HashMap
        Set<Integer> set = new HashSet<Integer>();

        for(int num : nums) {
            if(set.contains(num)){
                return true;
            }
            set.add(num);
        }
        return false;


    }
}