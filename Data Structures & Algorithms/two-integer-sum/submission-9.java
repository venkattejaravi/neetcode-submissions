class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numToIndexMap = new HashMap<>();
        int y;
        for(int i = 0; i < nums.length; i++) {
            y = target - nums[i];
            if(numToIndexMap.containsKey(y)) return new int[]{numToIndexMap.get(y), i};
            numToIndexMap.put(nums[i], i);
        }

        return new int[]{};
    }
}
