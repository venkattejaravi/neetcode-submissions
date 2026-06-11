class MinStack {
    private Stack<Integer> minStack;
    private List<Integer> stack;

    public MinStack() {
        this.minStack = new Stack<>();
        this.stack = new ArrayList<>();
    }
    
    public void push(int val) {
        if(!this.minStack.isEmpty()){
            if(val <= this.minStack.peek()){
                this.minStack.push(val);
            }
        } else {
            this.minStack.push(val);
        }

        this.stack.add(val);
    }
    
    public void pop() {
        if((!this.minStack.isEmpty()) && (this.minStack.peek().equals(this.stack.get(this.stack.size() - 1)))){
            this.minStack.pop();
        }
        
        this.stack.remove(stack.size() - 1);
    }
    
    public int top() {
        if(this.stack.size() == 0){
            return -1;
        }
        return this.stack.get(stack.size() - 1);
    }
    
    public int getMin() {
        return this.minStack.peek();
    }
}
