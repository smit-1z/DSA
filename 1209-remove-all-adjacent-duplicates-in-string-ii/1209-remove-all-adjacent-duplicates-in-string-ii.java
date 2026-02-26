class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Character> charStack = new Stack<>();
        Stack<Integer> freqStack = new Stack<>();

        for(char c:s.toCharArray()){
            if(charStack.isEmpty() || c != charStack.peek()) {
                charStack.push(c);
                freqStack.push(1);
            }else if(c == charStack.peek()){
                    int freq = freqStack.pop();
                    freq++;
                    freqStack.push(freq);
                    if(!freqStack.isEmpty() && freqStack.peek() == k){
                        freqStack.pop();
                        charStack.pop();
                    }
        }
        }
        StringBuilder res = new StringBuilder();

        while(!charStack.isEmpty()){
            int freq = freqStack.pop();
            char c = charStack.pop();
            for(int i=0;i<freq;i++){
                res.append(c);
            }
        }

        return res.reverse().toString();
    }
}