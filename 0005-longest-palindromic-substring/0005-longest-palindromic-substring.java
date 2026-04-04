class Solution {
    public String longestPalindrome(String s) {
        String res = new String();

        for(int i=0;i<s.length();i++){
            String a = getLongestString(s, i, i);
            String b = getLongestString(s, i, i+1);

            if(b.length() > a.length()){
                a = b;
            }

            if(a.length() > res.length()){
                res = a;
            }
        } 
        return res;
    }

    public String getLongestString(String s, int l, int r){
        while(l >=0 && r < s.length()){
            if(s.charAt(l) != s.charAt(r)){
                break;
            }else{
                l--;
                r++;
            }
        }
        return s.substring(l+1, r);
    }
}