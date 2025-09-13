class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> curr = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);
                curr.add(node.val);
            }

            if(res.size() %2 !=0){
                res.add(curr.reversed());
            }else{
                res.add(curr);
            }
        }

        return res;
    }
}