class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        backTracking(0, new ArrayList<>(), s);
        return res;
    }

    public void backTracking(int start, List<String> path, String s) {
        if(start == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for(int end = start; end < s.length(); end++) {
            // we want to add the substring to the path only if it is a palindrome.
            if(isPalindrome(s.substring(start, end + 1))) {
                path.add(s.substring(start, end + 1));
                backTracking(end + 1, path, s);
                path.remove(path.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while(l<=r) {
            if(s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }
}
