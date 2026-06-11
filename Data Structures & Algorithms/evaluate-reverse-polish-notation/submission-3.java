class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String token : tokens){
            if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")){
                int b = stack.peek();
                stack.pop();
                int a = stack.peek();
                stack.pop();
                switch(token){
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(a - b);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    case "/":
                        stack.push(a / b);
                        break;
                    default:
                        break;                    
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return !stack.isEmpty()?stack.peek():-1;
    }
}
