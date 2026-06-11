class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }

        int[] hashSet = new int[26];

        for(int i = 0; i < s.length(); i++){
            hashSet[s.charAt(i) - 'a'] ++;
            hashSet[t.charAt(i) - 'a'] --;
        }

        for(int i : hashSet){
            if(i != 0){
                return false;
            }
        }
        return true;

    }
}
