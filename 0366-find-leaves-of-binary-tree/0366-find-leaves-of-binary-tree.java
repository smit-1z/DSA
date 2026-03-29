class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> findLeaves(TreeNode root) {
        if(root == null) return res;
        dfs(root);
        return res;
    }

    public int dfs(TreeNode root){
        if(root == null) return -1;

        int l = dfs(root.left);
        int r = dfs(root.right);

        int max = Math.max(l,r);

        if(res.size() == max + 1){
            res.add(new ArrayList<>());
        }

        res.get(max+1).add(root.val);
        return max+1;
    }
}