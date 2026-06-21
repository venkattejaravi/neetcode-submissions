class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        Arrays.sort(sArr);
        Arrays.sort(tArr);

        String sortedS = new String(sArr);
        String sortedT = new String(tArr);

        // System.out.println(sortedS);
        // System.out.println(sortedT);

        return sortedS.equals(sortedT);

    }
}
