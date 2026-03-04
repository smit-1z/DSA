class Solution {
    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        dfs(root);
        return diameter;
    }

    public int dfs(TreeNode root){
        if(root == null) return 0;
        int l = 0;
        int r = 0;

        if(root.left !=null) l = dfs(root.left);
        if(root.right !=null) r = dfs(root.right);
        diameter = Math.max(diameter, l + r);
        return Math.max(l,r) + 1;
    }
}