class Solution {
    public String decodeString(String s) {
        Stack<String> stringStack = new Stack<>();
        Stack<Integer> integerStack = new Stack<>();

        StringBuilder cur = new StringBuilder();

        int k =0;
        
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                k = k*10 + (c - '0');
            }else if(c == '['){
                stringStack.push(cur.toString());
                integerStack.push(k);
                cur = new StringBuilder();
                k = 0;
            }else if(c == ']'){
                String temp = cur.toString();
                cur = new StringBuilder(stringStack.pop());
                int count = integerStack.pop();
                for(int i=0;i<count;i++){
                    cur.append(temp);
                }
            }else{
                cur.append(c);
            }
        }
        return cur.toString();
    }
}