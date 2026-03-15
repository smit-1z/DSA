class Solution {

    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        if (Math.abs(dfs(root.left) - dfs(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right))
            return true;
        return false;
    }

    public int dfs(TreeNode root) {
        if (root == null)
            return 0;
        return (Math.max(dfs(root.left), dfs(root.right)) + 1);
    }
}