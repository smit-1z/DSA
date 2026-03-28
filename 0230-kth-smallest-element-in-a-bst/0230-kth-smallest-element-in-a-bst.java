class Solution {
    ArrayList<Integer> q = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {
        dfs(root);
        
        return q.get(k-1);
    }

    public void dfs(TreeNode root){
        if(root == null){
            return ;
        }

        dfs(root.left);
        q.add(root.val);
        dfs(root.right);
    }
}