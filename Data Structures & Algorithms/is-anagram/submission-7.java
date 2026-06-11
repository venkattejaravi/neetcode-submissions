class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        Arrays.sort(sArr);
        Arrays.sort(tArr);

        String sortS = Arrays.toString(sArr);
        String sortT = Arrays.toString(tArr);

        return  sortS.equals(sortT);
    }
}
