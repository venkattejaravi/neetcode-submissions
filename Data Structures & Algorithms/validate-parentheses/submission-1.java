class Solution {
    public boolean isValid(String s) {
        if(s.isEmpty()) return true;
        
        Map<Character, Character> parentheses = new HashMap<>();
        parentheses.put('(', ')');
        parentheses.put('{', '}');
        parentheses.put('[', ']');
        
        Stack<Character> stack = new Stack<>();


        for(char c : s.toCharArray()){
            if(c == ')' || c == '}' || c == ']'){
                if(!stack.isEmpty()){
                    if(parentheses.containsKey(stack.peek()) && parentheses.get(stack.peek()) == c) {
                        stack.pop();
                        continue;
                    }
                }
            }
            stack.push(c);
        }
        return stack.isEmpty();

    }
}
