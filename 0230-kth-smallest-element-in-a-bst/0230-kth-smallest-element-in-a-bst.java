class Solution {
    PriorityQueue<Integer> q = new PriorityQueue<>();

    public int kthSmallest(TreeNode root, int k) {
        dfs(root);
        for(int i=0;i<k-1;i++){
            q.poll();
        }
        return q.peek();
    }

    public void dfs(TreeNode root){
        if(root == null){
            return ;
        }

        q.offer(root.val);
        dfs(root.left);
        dfs(root.right);
    }
}