class Solution {
    public String longestPalindrome(String s) {
            String res = "";
        for(int i=0;i<s.length();i++){
            String a = getLongestLength(s, i, i);
            String b = getLongestLength(s, i, i+1);
            if(a.length() >b.length()){
                if(a.length() > res.length()){
                    res = a;
                }
            }else{
                if(b.length() > res.length()){
                    res = b;
                }
            }
        }

        return res;
    }

    public String getLongestLength(String s, int start, int end){
        
        while(start>=0 && end<s.length()){
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