class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> hashMap = new HashMap<String, List<String>>();

        for(String str : strs){
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String sortedString = new String(charArr);
            hashMap.putIfAbsent(sortedString, new ArrayList<String>());
            hashMap.get(sortedString).add(str);
        }
        return new ArrayList<>(hashMap.values());

    }
}
