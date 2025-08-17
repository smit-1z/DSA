class Solution {
    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();

        int i = s.length() - 1;

        while (i >= 0) {
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }

            int j = i;

            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }

            res.append(s.substring(i+1, j+1)).append(" ");
        }
        return res.toString().trim();
    }
}