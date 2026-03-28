class Solution {
    int res = -1;
    int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        res = root.val;
        dfs(root, k);
        return res;
    }

    public void dfs(TreeNode root, int k) {
        if (root == null)
            return;
        if (count == k)
            return;
        dfs(root.left, k);
        count++;

        if (count == k) {
            res = root.val;
            return;
        }

        dfs(root.right, k);
    }
}