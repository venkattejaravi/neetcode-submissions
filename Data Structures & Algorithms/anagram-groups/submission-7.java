class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // looping through the strings.
        // int[26] holding the frequency of alphabets in a string.
        // put this int[26] comparing with the strings if match is found add that
        // string to the int[26] key
        // return the values of the HashMap.
        // tc: O(m * n)
        // sc: O(n)
        Map<String, List<String>> hMap = new HashMap<>();

        for(String s: strs){
            int[] freq = new int[26];
            for(char c: s.toCharArray()){
                freq[c - 'a']++;
            }
            String key = Arrays.toString(freq);
            hMap.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(hMap.values());

    }
}
