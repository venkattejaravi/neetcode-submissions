class Solution {
    public boolean isAnagram(String s, String t) {
        int[] indices = new int[26];

        for(char c : s.toCharArray()) {
            indices[c - 'a'] ++;
        }

        for(char c : t.toCharArray()) {
            indices[c - 'a'] --;
        }

        for (int n : indices) {
            if(n != 0) return false;
        }
        return true;

    }
}
