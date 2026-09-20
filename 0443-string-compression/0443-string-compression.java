class Solution {
    public int compress(char[] chars) {
        int i = 0;
        int index = 0;

        while(i < chars.length){
            char c = chars[i];
            int count = 0;
            while(i<chars.length && chars[i] == c){
                count++;
                i++;
            }
            chars[index++] = c;
            if(count>1){
                for(char ch: Integer.toString(count).toCharArray()){
                    chars[index++] = ch;
                }
            }
        }
            return index;

    }
}