class Solution {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        dfs(root,0);
        return sum;
    }

    public void dfs(TreeNode root, long currentVal){
        currentVal = currentVal*10 + root.val;
        
        if(root.left == null && root.right == null){
            sum+= currentVal;
            return;
        }

        if(root.left!= null) dfs(root.left,currentVal);
        if(root.right != null) dfs(root.right,currentVal);
    }
}