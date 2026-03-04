class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Integer> freqStack = new Stack<>();
        Stack<Character> charStack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (charStack.isEmpty() || charStack.peek() != c) {
                charStack.push(c);
                freqStack.push(1);
            } else {
                int freq = freqStack.pop();
                freq += 1;
                if (freq == k) {
                    charStack.pop();
                } else {
                    freqStack.push(freq);
                }
            }
        }
 StringBuilder res = new StringBuilder();

        while(!charStack.isEmpty()){
            int freq = freqStack.pop();
            char c = charStack.pop();
            for(int i = 0;i<freq;i++){
                res.append(c);
            }
        }

        return res.reverse().toString();
    }
}