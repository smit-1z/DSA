class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int[] res = new int[temperatures.length];

        for(int i=1;i<temperatures.length;i++){
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                res[stack.peek()] = i - stack.peek();
                stack.pop();
            }   
            stack.push(i);
        }

        return res;
    }
}