class Solution {
    Map<Character, String> digitsToLetters = new HashMap<>();
    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0) return res;
        digitsToLetters.put('2', "abc");
        digitsToLetters.put('3', "def");
        digitsToLetters.put('4', "ghi");
        digitsToLetters.put('5', "jkl");
        digitsToLetters.put('6', "mno");
        digitsToLetters.put('7', "pqrs");
        digitsToLetters.put('8', "tuv");
        digitsToLetters.put('9', "wxyz");
        backTracking(0, new StringBuilder(), digits);
        return res;    
    }

    public void backTracking(int index, StringBuilder path, String digits) {
        if(path.length() == digits.length()) {
            res.add(path.toString());
            return;
        }

        for(int i = index; i < digits.length(); i++) {
            String letters = digitsToLetters.get(digits.charAt(i));
            for(char c : letters.toCharArray()) {
                path.append(c);
                backTracking(i + 1, path, digits);
                path.deleteCharAt(path.length() - 1);
            }
        }
    }
}
