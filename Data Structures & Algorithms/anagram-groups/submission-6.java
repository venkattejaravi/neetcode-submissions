class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // When we are traversing through the strings.
        // Sort the String and store the sorted string as key and String as value.
        // when you sort the string if that sorted string is already there in the hashMap
        // Then just add String to the list of that key in hashMap. and return that list.
        //Tc: O(m * nlogn) sorting
        // SC: O(m * n) HashMap
        Map<String, List<String>> anagrams = new HashMap<>();

        for(String s: strs){
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sortedS = new String(charArray);
            anagrams.computeIfAbsent(sortedS, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(anagrams.values());
    }
}
