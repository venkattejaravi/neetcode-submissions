class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        int[] s1Counter = new int[26];
        int[] wCounter = new int[26];
        int matches = 0;

        for(char c : s1.toCharArray()){
            s1Counter[c - 'a']++;
        }

        for(int i = 0; i < s1.length(); i++) {
            char c = s2.charAt(i);
            wCounter[c - 'a']++;
        }

        // Calculate matches
        for(int i = 0; i< s1Counter.length; i++)
            if(s1Counter[i] == wCounter[i]) matches++;
        
        int l = 0;
        for(int r = s1.length(); r < s2.length(); r++){
            if(matches == 26){
                return true;
            }

            // remove the s2.charAt(l) element
            int lIdx = s2.charAt(l) - 'a';
            wCounter[lIdx]--;
            if(s1Counter[lIdx] == wCounter[lIdx]) matches++;
            if(s1Counter[lIdx] - 1 == wCounter[lIdx]) matches--;

            // Add the s2.charAt(r) element
            int idx = s2.charAt(r) - 'a';
            wCounter[idx]++;
            if(s1Counter[idx] == wCounter[idx]) matches++;
            if(s1Counter[idx] + 1 == wCounter[idx]) matches--;
            
            l++;
        }
        return matches == 26;


    }
}
