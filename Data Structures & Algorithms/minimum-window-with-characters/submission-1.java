class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tCounter = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for(char c : t.toCharArray()){
            tCounter.put(c, tCounter.getOrDefault(c, 0) + 1);
        }

        int have = 0;
        int need = tCounter.size();

        int l = 0;
        int minLength = Integer.MAX_VALUE;
        int start = 0;

        for(int r = 0; r < s.length(); r++){
            char rChar = s.charAt(r);
            window.put(rChar, window.getOrDefault(rChar, 0) + 1);

            if(tCounter.containsKey(rChar) && window.get(rChar) == tCounter.get(rChar)){
                have++;
            }

            while(have == need) {
                if(r - l + 1 < minLength) {
                    minLength = r - l + 1;
                    start = l;
                }
                char lChar = s.charAt(l);
                window.put(lChar, window.get(lChar) - 1);
                if(tCounter.containsKey(lChar) && window.get(lChar) < tCounter.get(lChar)) {
                    have--;
                }
                l++;
            }

        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength); 
    }
}
