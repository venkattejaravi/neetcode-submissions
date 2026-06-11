class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, new ArrayList<>(), nums);
        return res;
    }

    public void dfs(int i, List<Integer> subSet, int[] nums) {
        if(i >= nums.length) {
            res.add(new ArrayList<>(subSet));
            return;
        }

        subSet.add(nums[i]);
        dfs(i + 1, subSet, nums);

        subSet.remove(subSet.size() - 1);
        dfs(i + 1, subSet, nums);
    }
}
