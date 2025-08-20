class Solution {
    public String longestCommonPrefix(String[] strs) {
        String word = strs[0];

        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            for(String str:strs){
                if(i == str.length() || str.charAt(i) != c){
                    return word.substring(0,i);
                }
            }
        }

        return word;
    }
}