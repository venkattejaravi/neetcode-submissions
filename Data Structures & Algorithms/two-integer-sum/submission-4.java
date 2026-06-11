class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Bruteforce
        
        // for(int i = 0; i < nums.length - 1; i++){
        //     for(int j = i + 1; j < nums.length; j++) {
        //         if(nums[i] + nums[j] == target) {
        //             return new int[] {i, j};
        //         }
        //     }
        // }
        // return new int[] {};

        // Time complexity: O(n ^ 2)
        // Space complexity: O(1)

        // HashMap
        Map<Integer, Integer> seen = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            int diff = target - num;

            if (seen.containsKey(diff)) {
                return new int[] {seen.get(diff), i};
            }
            seen.put(num, i);
        }
        return new int[] {};

        // Time Complexity : O(n)
        // Space complexity : O(n)

    }
}
