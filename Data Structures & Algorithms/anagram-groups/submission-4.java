class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> hashMap = new HashMap<>();

        for(String str : strs) {
            int[] idxArray = new int[26];
            for(char c : str.toCharArray()){
                idxArray[c - 'a'] ++;
            }
            String key = Arrays.toString(idxArray);
            hashMap.putIfAbsent(key, new ArrayList<>());
            hashMap.get(key).add(str);
        }
        return new ArrayList<>(hashMap.values());
    }
}
