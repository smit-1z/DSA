class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> findLeaves(TreeNode root) {
        this.res = new ArrayList<>();
        dfs(root);
        return res;
    }

    public int dfs(TreeNode root){
        if(root == null) return -1;
        int l = dfs(root.left);
        int r = dfs(root.right);

        int max = Math.max(l, r) + 1;

        if(max == res.size()) res.add(new ArrayList<>());
        res.get(max).add(root.val);

        return max;
    }
}