class Solution {
    public String longestPalindrome(String s) {
        
        int start = 0;
        int end = 0;
        
        String str= "";
        String currString = "";
        
        for(int i=0; i<s.length(); i++) {
            int len1 = isPalindrome(s,i,i);
            int len2 = isPalindrome(s,i,i+1);
            int maxLen = Math.max(len1,len2);
            if(maxLen > end-start){
                start  = i - (maxLen-1)/2;
                end = i + maxLen/2;
            }
        }
    return s.substring(start,end+1);
    }
    
    public int isPalindrome(String s,int fIdx,int sIdx){
        if(s == null || fIdx >sIdx) return 0;
        int left = fIdx;
        int right = sIdx;
        while(left >= 0 && right <s.length() && s.charAt(left) == s.charAt(right)){
                left--;
                right++;
        }
        return right - left - 1; 
    }
}