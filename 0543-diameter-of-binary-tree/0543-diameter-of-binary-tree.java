class Solution {
    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return diameter;
    }

    public int dfs(TreeNode root){
        if(root == null) return 0;
        int leftMax = dfs(root.left);
        int rightMax = dfs(root.right);
        diameter = Math.max((leftMax + rightMax), diameter);
        return Math.max(leftMax, rightMax) + 1;
    }
}