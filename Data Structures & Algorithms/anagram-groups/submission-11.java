class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();

        if(strs.length == 0) return res;

        Map<String, List<String>> map = new HashMap<>();

        for(String str: strs) {
            int[] freq = new int[26];
            for(char c : str.toCharArray()) {
                freq[c - 'a']++;
            }
            String key = Arrays.toString(freq);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
