class Solution {

    public String encode(List<String> strs) {
        //4#neet4#code4#love3#you
        String output = "";
        for(String s: strs){
            output += (s.length()) + "#" + s;
        }
        return output;
    }

    public List<String> decode(String str) {
        // if we found the delimiter we can just calculate the length before that delim.
        // Calculate the preceding string based on length and add it to the output List.
        int i = 0;
        int j;
        List<String> res = new ArrayList<>();

        while(i < str.length()){
            j = i;
            while(str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            res.add(str.substring(j + 1, j + length + 1));
            i = j + length + 1;
        }
        return res;
    }
}
