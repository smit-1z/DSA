class Solution {
    public String longestPalindrome(String s) {
        String res = new String();

        for(int i=0;i<s.length();i++){
            String s1 = getLongestPalindrom(s, i,i);
            String s2 = getLongestPalindrom(s, i,i+1);

            if(s2.length() > s1.length() ){
               s1 = s2;
            }
            
            if(s1.length() > res.length()){
               res = s1;
            }

        }

        return res;
    }

    public String getLongestPalindrom(String s, int i, int j){
        
        while(i >=0 && j <s.length()){
            if(s.charAt(i) != s.charAt(j)){
              break;
            }
            i--;
            j++;
        }
        return s.substring(i+1,j);
    }

}