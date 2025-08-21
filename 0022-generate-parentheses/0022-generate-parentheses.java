class Solution {
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        generate(n, new StringBuilder(), 0, 0);
        return res;
    }

    public void generate(int n, StringBuilder curr, int open, int close) {
        if (curr.length() == n * 2) {
            res.add(new String(curr));
            return;
        }

        if (open < n) {
            curr.append("(");
            generate(n, curr, open + 1, close);
            curr.deleteCharAt(curr.length() - 1);
        }

        if (close < open) {
            curr.append(")");
            generate(n, curr, open, close + 1);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}