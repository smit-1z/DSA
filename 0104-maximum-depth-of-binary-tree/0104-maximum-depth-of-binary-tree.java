class Solution {
    int res = 0;
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        dfs(root);
        return res;
    }

    public int dfs(TreeNode root){
        if(root == null) return 0;
        int l = dfs(root.left);
        int r = dfs(root.right);
        int max =  Math.max(l,r);
        res = Math.max(res,max+1); 
        return max+1;
    }
}