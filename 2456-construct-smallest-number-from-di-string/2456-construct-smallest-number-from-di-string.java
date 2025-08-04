class Solution {
    public String smallestNumber(String pattern) {
        Stack<Integer> stack = new Stack<>();
        int n = pattern.length();
        StringBuilder res = new StringBuilder();

        for(int i=0;i<=n;i++){
            stack.push(i+1);

           if(i==n || pattern.charAt(i) == 'I'){
            while(!stack.isEmpty()){
                res.append(stack.pop());
            }
           }
        }

        return res.toString();
    }
}