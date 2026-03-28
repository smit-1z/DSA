class Solution {
    int res = -1;
    int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return res;
    }

    public void dfs(TreeNode root, int k) {
        if (root == null || count == k) {
            return;
        }

        dfs(root.left, k);

        if (count == k) return;

        count++;
        if (count == k) {
            res = root.val;
            return;
        }

        dfs(root.right, k);
    }
}