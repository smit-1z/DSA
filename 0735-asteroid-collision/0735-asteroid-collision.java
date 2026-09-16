class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int a : asteroids) {
            while (!stack.isEmpty() && stack.peek() > 0 && a < 0) {
                if (stack.peek() < -a) {
                    stack.pop();
                } else {
                    if(stack.peek() == -a) stack.pop();
                    a = 0;
                    break;
                }
            }

            if(a != 0) stack.push(a);
        }

        int[] res = new int[stack.size()];

        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }

        return res;
    }
}