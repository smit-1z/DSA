class MinStack {
    LinkedList<Integer> stack;
    LinkedList<Integer> minStack;

    public MinStack() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
    }
    
    public void push(int val) {
        stack.add(val);
        if (minStack.isEmpty() || minStack.getLast() >= val) {
            minStack.add(val);
        }
    }
    
    public void pop() {
        if (stack.getLast().equals(minStack.getLast())) {
            minStack.removeLast();
        }
        stack.removeLast();
    }
    
    public int top() {
        return stack.getLast();
    }
    
    public int getMin() {
        return minStack.getLast();
    }
}
