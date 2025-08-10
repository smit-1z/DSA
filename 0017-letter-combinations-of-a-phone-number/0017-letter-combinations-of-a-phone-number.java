class Solution {
    private List<String> res = new ArrayList<>();

    private String[] digitToChar = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return res;
        backTrack(0,new StringBuilder(),digits);
        return res;
    }

    public void backTrack(int pos,StringBuilder currString, String digits) {
        if(currString.length() == digits.length()){
            res.add(currString.toString());
            return;
        }

        String chars = digitToChar[digits.charAt(pos) - '0'];

        for(char c:chars.toCharArray()){
            backTrack(pos+1, currString.append(c), digits);
            currString.deleteCharAt(currString.length() -1);
        }
    }
}