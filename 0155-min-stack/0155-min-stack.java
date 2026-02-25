class MinStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> min = new Stack<>();

    public MinStack() {
        this.stack = new Stack<>();
        this.min = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(min.isEmpty() || min.peek() >= val){
            min.push(val);
        }
    }
    
    public void pop() {
        int pop = stack.pop();
        if(min.peek().equals(pop)){
            min.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}