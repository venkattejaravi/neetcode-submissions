class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        backTracking(0, new ArrayList<>(), nums, target);
        return res;
    }

    public void backTracking(int index, List<Integer> path, int[] nums, int target ) {
        if(target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        if(target < 0) return;

        for(int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            backTracking(i, path, nums, target - nums[i]);
            path.remove(path.size() - 1);
        }
    }
}
