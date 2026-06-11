class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        Map<Character, Integer> s1Counter = new HashMap<>();
        Map<Character, Integer> wCounter = new HashMap<>();

        for(char c : s1.toCharArray()){
            s1Counter.put(c, s1Counter.getOrDefault(c, 0) + 1);
        }

        for(int i = 0; i < s1.length(); i++) {
            char c = s2.charAt(i);
            wCounter.put(c, wCounter.getOrDefault(c, 0) + 1);  
        }
        int l = 0;
        for(int r = s1.length(); r < s2.length(); r++){
            if(s1Counter.equals(wCounter)){
                return true;
            }

            // remove the s2.charAt(l) element
            char lChar = s2.charAt(l);
            wCounter.put(lChar, wCounter.getOrDefault(lChar, 0) - 1);
            if(wCounter.get(lChar) <= 0) wCounter.remove(lChar);

            // Add the s2.charAt(r) element
            char rChar = s2.charAt(r);
            wCounter.put(rChar, wCounter.getOrDefault(rChar, 0) + 1);
            
            l++;
        }
        return s1Counter.equals(wCounter);


    }
}
