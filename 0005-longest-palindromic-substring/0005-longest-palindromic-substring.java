class Solution {
    public String longestPalindrome(String s) {
        int resLen = 0;
        int start =0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            
            int l1 = findLongestPalindrome(i, i, s);
            int l2 = findLongestPalindrome(i, i+1, s);
            
            resLen = Math.max(l1,l2);
            if(resLen > end-start){
                start = i - (resLen-1)/2;
                end = i+resLen/2;
            }
        }

        return s.substring(start, end+1);
    }

    public int findLongestPalindrome(int l, int r, String s) {
        
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }

        return r-l-1;
    }
}