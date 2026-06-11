class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTracking(0, new ArrayList<>(), candidates, target);
        return res;    
    }

    public void backTracking(int index, List<Integer> path, int[] candidates, int target) {
        if(target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        if(target < 0) return;

        for(int i = index; i < candidates.length; i++) {
            if(i > index && candidates[i] == candidates[i - 1]) continue;
            path.add(candidates[i]);
            backTracking(i + 1, path, candidates, target - candidates[i]);
            path.remove(path.size() - 1);
        }
    }
}
