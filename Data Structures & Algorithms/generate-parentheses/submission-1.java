class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        backTracking(0, 0, n, res, stack);
        return res;
    }

    public void backTracking(int openN, int closeN, int n, List<String> res, Stack<String> stack){
        if(openN == n && closeN == n){
            StringBuilder sb = new StringBuilder();
            for(String s : stack){
                sb.append(s);        
            }
            res.add(sb.toString());
            return;
        }

        if(openN < n){
            stack.push("(");
            backTracking(openN + 1, closeN, n, res, stack);
            stack.pop();
        }

        if(closeN < openN) {
            stack.push(")");
            backTracking(openN, closeN + 1, n, res, stack);
            stack.pop();
        }
    }

    
}
