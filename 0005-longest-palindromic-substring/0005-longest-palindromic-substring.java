class Solution {
    public String longestPalindrome(String s) {
        int resLen = 0;
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            //odd Length
            int l = i;
            int r = i;

            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > resLen) {
                    res = s.substring(l, r + 1);
                    resLen = r - l + 1;
                }
                l--;
                r++;
            }

            //Even Length
            l = i;
            r = i + 1;

            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > resLen) {
                    res = s.substring(l, r + 1);
                    resLen = r - l + 1;
                }
                l--;
                r++;
            }
        }
        return res;
    }
}