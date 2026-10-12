class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        int num = 0;
        int i = 0;

        while (i < s.length()) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }

            if ((!Character.isWhitespace(c) && !Character.isDigit(c)) || i == s.length() - 1) {
                if (sign == '+') {
                    stack.push(num);
                }

                if (sign == '-') {
                    stack.push(-num);
                }

                if (sign == '*') {
                    stack.push(stack.pop() * num);
                }

                if (sign == '/') {
                    stack.push(stack.pop() / num);
                }

                sign = c;
                num = 0;
            }
            i++;
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }

        return res;
    }
}