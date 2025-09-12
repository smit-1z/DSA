class Solution {
    public int strStr(String haystack, String needle) {
        for(int i=0;i<haystack.length() - needle.length() + 1;i++){
            if(haystack.substring(i).startsWith(needle)){
                return i;
            }
        }

        return -1;
    }
}