class Solution {
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        generate(n, 0, 0, new StringBuilder() );
        return res;
    }

    public void generate(int n, int open, int close, StringBuilder current) {
        if (current.length() == n * 2) {
            res.add(new String(current));
            return;
        }

        if (open < n) {
            current.append('(');
            generate(n, open + 1,close, current);
            current.deleteCharAt(current.length() - 1);
        }

        if (close < open) {
            current.append(')');
            generate(n, open,close+1, current);
            current.deleteCharAt(current.length() - 1);
        }
    }
}