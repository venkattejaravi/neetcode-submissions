class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<Integer, Integer>();
        List<Integer>[] freq = new List[nums.length + 1];

        for(int num : nums){
            counter.put(num, 1 + counter.getOrDefault(num, 0));
        }

        for(int i = 0; i < freq.length; i++){
            freq[i] = new ArrayList<>();
        }

        for(Map.Entry<Integer, Integer> entry : counter.entrySet()){
            freq[entry.getValue()].add(entry.getKey());
        }

        int[] result = new int[k];
        int j = 0;
        for(int i = freq.length - 1; i >= 0 && j < k; i --){
            for(int n : freq[i]){
                result[j++] = n;
                if(j == k){
                    return result;
                }
            }
        } 
        return result;

    }
}
