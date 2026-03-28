class Solution {
    ArrayList<Integer> q = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {
        dfs(root,k);
        return q.get(k-1);
    }

    public void dfs(TreeNode root,int k){
        if(root == null || q.size() == k){
            return ;
        }

        dfs(root.left,k);
        q.add(root.val);
        dfs(root.right,k);
    }
}