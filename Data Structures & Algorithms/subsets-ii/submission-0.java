class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backTracking(0, new ArrayList<>(), nums);
        return res;    
    }

    public void backTracking(int index, List<Integer> path, int[] nums) {
        res.add(new ArrayList<>(path));

        for(int i = index; i < nums.length; i++) {
            if(i > index && nums[i] == nums[i - 1]) continue;
            path.add(nums[i]);
            backTracking(i + 1, path, nums);
            path.remove(path.size() - 1);
        }
    }
}
