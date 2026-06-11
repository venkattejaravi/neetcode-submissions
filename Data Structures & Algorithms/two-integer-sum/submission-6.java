class Solution {
    public int[] twoSum(int[] nums, int target) {
        // loop through the nums
        // num1 + num2 = target
        // num2 = target - num1
        // maintain a HashMap<Integer, Integer>. Look for the num2 in HashMap
        // if the number is there return the return the value of teh num2 key and present value index.

        Map<Integer, Integer> hashMap = new HashMap<>();
        int num2;
        for(int i = 0; i < nums.length; i++){
            num2 = target - nums[i];
            if(hashMap.containsKey(num2)){
                return new int[]{hashMap.get(num2), i};
            } else {
                hashMap.put(nums[i], i);
            }
        }
        return new int[]{};

    }
}
