class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Bucket Sort
        // Where we need an Array of maximum size of nums.
        // We consider the indices as the freq of the numbers
        // A list of  numbers that has the freq matching with the index.
        // At the end we return the values while looping through the indices array in reverse.
        //SC : O(n)
        //tc: O(n)

        List<Integer>[] freq = new ArrayList[nums.length + 1];
        for(int i = 0; i < freq.length; i++){
            freq[i] = new ArrayList<>();
        }
        Map<Integer, Integer> hMap = new HashMap<>(); 
        for(int n : nums){
            hMap.put(n, hMap.getOrDefault(n, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : hMap.entrySet()){
            freq[entry.getValue()].add(entry.getKey());            
        }
        int[] output = new int[k];
        int j = 0;

        for(int i = freq.length - 1; i >=0; i--){
            for(int n : freq[i]){
                output[j++] = n;
                if(j == k) {
                    return output;
                }
            }
        }
        return output;
    }
}
