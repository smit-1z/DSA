class Solution {
    public String decodeString(String s) {
        Stack<Integer> intStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        StringBuilder curr = new StringBuilder();

        int digit = 0;
        for(char c:s.toCharArray()){
            if(Character.isDigit(c)){
                digit = digit*10 + (c - '0');
            }
            else if(c == '['){
                stringStack.push(curr.toString());
                curr = new StringBuilder();
                intStack.push(digit);
                digit = 0;
            }
            else if(c == ']'){
              String temp = curr.toString();
              curr = new StringBuilder(stringStack.pop());

                int d = intStack.pop();

                for(int i=0;i<d;i++){
                    curr.append(temp);
                }
            }else{
                curr.append(c);
            }
        }
        return curr.toString();
    }
}