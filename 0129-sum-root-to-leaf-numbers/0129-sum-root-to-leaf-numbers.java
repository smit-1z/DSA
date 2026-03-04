class Solution {
    int sum = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        dfs(root, 0);
        return sum;
    }

    public void dfs(TreeNode root, int currentVal) {
        currentVal = currentVal * 10 + root.val;
        
        if (root.left == null && root.right == null) {
            sum += currentVal;
        } else {
            dfs(root.left, currentVal);
            dfs(root.right, currentVal);
        }
    }
}