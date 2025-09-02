class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (token.equals("-")) {
                stack.add(-stack.pop()+stack.pop());
            } else if (token.equals("+")) {
                stack.add(stack.pop()+stack.pop());
            } else if (token.equals("*")) {
                stack.add(stack.pop()*stack.pop());
            } else if (token.equals("/")) {
                int op2 = stack.pop();
                int op1 = stack.pop();
                stack.add(op1/op2);
            }else{
                stack.add(Integer.parseInt(token));
            }
        }

        return stack.peek();
    }
}
