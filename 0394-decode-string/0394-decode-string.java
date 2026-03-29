class Solution {
    public String decodeString(String s) {
        Stack<Integer> intStack = new Stack<>();
        Stack<String> charStack = new Stack<>();

        StringBuilder curr = new StringBuilder();
        int digit = 0;

        for(int i=0;i<s.length();i++){
            if(Character.isDigit(s.charAt(i))){
                digit = digit*10 + (s.charAt(i) - '0');
            }else if(s.charAt(i) == '['){
                charStack.push(curr.toString());
                intStack.push(digit);
                curr = new StringBuilder();
                digit = 0;
            }else if (s.charAt(i) == ']'){
                String temp = curr.toString();
                curr = new StringBuilder(charStack.pop());
                int freq = intStack.pop();
                for(int j=0;j<freq;j++){
                    curr.append(temp);
                }
            }else{
                curr.append(s.charAt(i));
            }
        } 
        return curr.toString();
    }
}