class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        String res = "";

        for(int i=0;i<s.length();i++){
            String s1 = getLongestP(s,i,i);
            String s2 = getLongestP(s,i,i+1);
            if(s2.length() > s1.length()){
                s1 = s2;
            }
            if(s1.length() > res.length()){
                res = s1;
            }
        }

        return res;
    }

    public String getLongestP(String s, int start, int end){
        
        while(start >= 0 && end < s.length()){
            if(s.charAt(start) != s.charAt(end)){
                break;
            }else{
                start--;
                end++;
            }
        }
        return s.substring(start+1,end);
    }
}