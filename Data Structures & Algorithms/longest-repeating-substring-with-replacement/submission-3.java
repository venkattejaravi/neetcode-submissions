class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> counter = new HashMap<>();
        int l = 0;
        int maxLength = 0;
        int maxFreq = 0;

        for(int r = 0; r < s.length(); r++){
            counter.put(s.charAt(r), counter.getOrDefault(s.charAt(r), 0) + 1);
            maxFreq = Math.max(maxFreq, counter.get(s.charAt(r)));
            while (((r - l + 1) - maxFreq) > k ){
                counter.put(s.charAt(l), counter.get(s.charAt(l)) - 1);
                l++;
            }
            
            maxLength = Math.max(maxLength, r - l + 1);
        }
        return maxLength;
    }
}
