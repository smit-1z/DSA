class Solution {
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        generate(n,0,0,new StringBuilder());
        return res;
    }

    public void generate(int n,int open,int close ,StringBuilder pattern){
        if(open+close == n*2){
            res.add(new String(pattern));
        }

            if(open <n){
                pattern.append("(");
                generate(n,open+1,close,pattern);
                pattern.deleteCharAt(pattern.length() -1);
            }

            if(close < open){
                pattern.append(")");
                generate(n,open,close+1,pattern);
                pattern.deleteCharAt(pattern.length() -1);
            }
    }
}