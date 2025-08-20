class Solution {
    public int myAtoi(String s) {
        int n =  s.length();
       

        long res = 0;
        long sign = 1;
        int i = 0;
        while(i<n && Character.isWhitespace(s.charAt(i))) i++;
        
        if (i < n && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            sign = s.charAt(i) == '-' ? -1 : 1;
            i++;
        }

        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit  = s.charAt(i) - '0';

            res = res* 10 + digit;

           if(sign == 1 && res >= Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
           }

           if(sign == -1 && -res <= Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
           }
           i++;
        }

        return (int) (sign*res);
    }
}

