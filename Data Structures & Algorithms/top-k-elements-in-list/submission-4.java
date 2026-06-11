class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> counter = new HashMap<>();
        for(int n : nums) {
            counter.put(n, 1 + counter.getOrDefault(n, 0));
        }
        
        ArrayList<Integer>[] freq = new ArrayList[nums.length + 1];
        // key -> number value -> freq(index)

        for(int i = 0; i < freq.length; i++){
            freq[i] = new ArrayList<>();
        }

        for(Map.Entry<Integer, Integer> entry: counter.entrySet()){
            freq[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];
        int index = 0;
        for(int i = freq.length - 1; i >= 0 && index < k; i --){
                for(int n : freq[i]){
                    res[index++] = n;
                    if(index == k){
                        return res;
                    }
                }
            
        }

        return res;

    }
}
