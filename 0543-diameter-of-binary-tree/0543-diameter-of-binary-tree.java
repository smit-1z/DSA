class Solution {
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return diameter;
        dfs(root);
        return diameter;
    }

    public int dfs(TreeNode root) {
        if (root == null)
            return 0;

        int l = dfs(root.left);
        int r = dfs(root.right);

        diameter = Math.max((l + r), diameter);
        return Math.max(l,r) + 1;
    }
}