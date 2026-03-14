
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        dfs(root);
        return root;
    }

    public TreeNode dfs(TreeNode root){
        if(root == null) return root;
        TreeNode l = dfs(root.left);
        TreeNode r = dfs(root.right);
        root.left = r;
        root.right = l;
        return root;
    }
}