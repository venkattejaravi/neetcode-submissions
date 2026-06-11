class Solution {
    public boolean hasDuplicate(int[] nums) {
        
        HashSet<Integer> hashSet = new HashSet<Integer>();

        for(int n: nums){
            if(hashSet.contains(n)){
                return true;
            }
            else {
                hashSet.add(n);
            }
        }
        return false;
    }
}