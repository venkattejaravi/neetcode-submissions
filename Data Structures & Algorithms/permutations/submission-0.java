class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        backTracking(used, new ArrayList<>(), nums);
        return res;
    }

    public void backTracking(boolean[] used, List<Integer> path, int[] nums) {
        if(path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(used[i]) continue;
            path.add(nums[i]);
            used[i] = true;

            backTracking(used, path, nums);

            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}
