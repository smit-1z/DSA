class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for(int asteroid:asteroids){
            while(!stack.isEmpty() && stack.peek() > 0 && asteroid < 0){
                if(stack.peek() < - asteroid){
                    stack.pop();
                }else if(-asteroid == stack.peek()){
                    stack.pop();
                    asteroid = 0;
                    break;
                }else{
                    asteroid = 0;
                    break;
                }
            }
            if(asteroid != 0) stack.push(asteroid);
        }

        int[] res = new int[stack.size()];
        for(int i=res.length-1;i>=0;i--){
            res[i] = stack.pop();
        }
        return res;
    }
}
