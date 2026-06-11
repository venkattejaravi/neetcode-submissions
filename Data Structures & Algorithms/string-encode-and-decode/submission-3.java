class Solution {

    public String encode(List<String> strs) {
        String result = "";
        for(String str: strs){
            result = result + String.valueOf(str.length()) + '#' + str;
        }
        return result;
    }

    public List<String> decode(String str) {
        List<String> resStr = new ArrayList<String>();

        int i = 0;
        int j;
        
        while(i < str.length()) {
            j = i;
            while(str.charAt(j) != '#'){
                j += 1;
            }
            int length = Integer.parseInt(str.substring(i, j));
            resStr.add(str.substring(j + 1, j + length + 1));
            i = j + length + 1;
            
        }
        return resStr;
    }
}
